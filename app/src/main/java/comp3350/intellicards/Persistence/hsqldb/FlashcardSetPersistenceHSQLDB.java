package comp3350.intellicards.Persistence.hsqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comp3350.intellicards.Objects.Flashcard;
import comp3350.intellicards.Objects.FlashcardSet;
import comp3350.intellicards.Persistence.FlashcardSetPersistence;

public class FlashcardSetPersistenceHSQLDB implements FlashcardSetPersistence {
    private final String dbPath;

    public FlashcardSetPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private FlashcardSet fromResultSet(final ResultSet rs) throws SQLException {
        final String setID = rs.getString("setID");
        final String username = rs.getString("username");
        final String setName = rs.getString("setName");

        return new FlashcardSet(setID, username, setName);
    }

    @Override
    public FlashcardSet getFlashcardSet(String uuid) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM FLASHCARDSETS WHERE setID = ?");
            st.setString(1, uuid);

            final ResultSet rs = st.executeQuery();

            rs.next();
            final FlashcardSet flashcardSet = fromResultSet(rs);

            rs.close();
            st.close();

            return flashcardSet;
        }
        catch (SQLException e) {
            e.printStackTrace();
            //throw new PersistenceException(e);
        }

        //Delete this return statement after implementing exception
        return null;
    }

    @Override
    public FlashcardSet getActiveFlashcardSet(String uuid) {
        try (final Connection c = connection()) {
            FlashcardSet flashcardSet = getFlashcardSet(uuid);

            if(flashcardSet != null) {
                final PreparedStatement st = c.prepareStatement("SELECT * FROM FLASHCARDS WHERE setID = ? AND deleted = FALSE");
                st.setString(1, uuid);
                final ResultSet rs = st.executeQuery();

                while(rs.next()) {
                    final Flashcard flashcard = new Flashcard(rs.getString("cardID"), rs.getString("setID"), rs.getString("answer"), rs.getString("question"), rs.getString("hint"), rs.getBoolean("deleted"), rs.getInt("attempts"), rs.getInt("correct"));
                    flashcardSet.addFlashcard(flashcard);
                }
                return flashcardSet.getActiveFlashcards();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            //throw new PersistenceException(e);
        }

        //Delete this return statement after implementing exception
        return null;
    }

    @Override
    public List<FlashcardSet> getAllFlashcardSets() {
        List<FlashcardSet> flashcardSets = new ArrayList<>();

        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("SELECT * FROM FLASHCARDSETS");

            final ResultSet rs = st.executeQuery();
            while(rs.next()) {
                final FlashcardSet flashcardSet  = fromResultSet(rs);
                flashcardSets.add(flashcardSet);
            }

            rs.close();
            st.close();

            return flashcardSets;
        }
        catch (SQLException e) {
            e.printStackTrace();
            //throw new PersistenceException(e);
        }

        //Delete this return statement after implementing exception
        return null;
    }

    @Override
    public void insertFlashcardSet(FlashcardSet newFlashcardSet) {
        try (final Connection c = connection()) {
            final PreparedStatement st = c.prepareStatement("INSERT INTO FLASHCARDSETS VALUES(?, ?, ?)");

            st.setString(1, newFlashcardSet.getUUID());
            st.setString(2, newFlashcardSet.getUsername());
            st.setString(3, newFlashcardSet.getFlashcardSetName());

            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            //throw new PersistenceException(e);
        }
    }

    @Override
    public boolean addFlashcardToFlashcardSet(String setUUID, Flashcard flashcard) {
        try (final Connection c = connection()) {
            FlashcardSet flashcardSet = getFlashcardSet(setUUID);

            if(flashcardSet != null) {
                flashcardSet.addFlashcard(flashcard);
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            //throw new PersistenceException(e);
        }

        //Delete this return statement after implementing exception
        return false;
    }

    @Override
    public void randomizeFlashcardSet(FlashcardSet flashcardSet) {
        try (final Connection c = connection()) {
            if(flashcardSet != null) {
                flashcardSet.randomizeSet();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            //throw new PersistenceException(e);
        }
    }
}
