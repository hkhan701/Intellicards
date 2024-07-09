package comp3350.intellicards.Business;

import java.util.List;

import comp3350.intellicards.Application.Services;
import comp3350.intellicards.Objects.Flashcard;
import comp3350.intellicards.Persistence.FlashcardPersistence;

public class FlashcardManager {
    private FlashcardPersistence flashcardPersistence;

    public FlashcardManager() {
        flashcardPersistence = Services.getFlashcardPersistence();
    }

    public FlashcardManager(FlashcardPersistence persistence) {
        flashcardPersistence = persistence;
    }

    public Flashcard getFlashcard(String uuid) {
        return this.flashcardPersistence.getFlashcard(uuid);
    }

    public void insertFlashcard(Flashcard currFlashcard) {
        this.flashcardPersistence.insertFlashcard(currFlashcard);
    }

    public void updateFlashcard(Flashcard currFlashcard) {
        this.flashcardPersistence.updateFlashcard(currFlashcard);
    }

    public void markFlashcardAsDeleted(String uuid) {
        this.flashcardPersistence.markFlashcardAsDeleted(uuid);
    }

    public void restoreFlashcard(String uuid) {
        this.flashcardPersistence.restoreFlashcard(uuid);
    }

    public void markAttempted(String uuid) {
        this.flashcardPersistence.markAttempted(uuid);
    }

    public void markAttemptedAndCorrect(String uuid) {
        this.flashcardPersistence.markAttemptedAndCorrect(uuid);
    }

}