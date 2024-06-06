package comp3350.intellicards.Persistence;

import java.util.List;

import comp3350.intellicards.Objects.Flashcard;
import comp3350.intellicards.Objects.FlashcardSet;

public interface FlashcardSetPersistence {
    FlashcardSet getFlashcardSet(String flashcardSetId);

    FlashcardSet getActiveFlashcardSet(String flashcardSetId);

    List<FlashcardSet> getAllFlashcardSets();

    boolean insertFlashcardSet(FlashcardSet newFlashcardSet);

    boolean addFlashCardToFlashcardSet(FlashcardSet flashcardSet, Flashcard flashcard);

}
