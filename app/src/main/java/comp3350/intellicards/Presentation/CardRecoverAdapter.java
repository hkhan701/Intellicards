package comp3350.intellicards.Presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import comp3350.intellicards.Objects.Flashcard;
import comp3350.intellicards.Objects.FlashcardSet;
import comp3350.intellicards.R;

public class CardRecoverAdapter extends RecyclerView.Adapter<CardRecoverAdapter.ViewHolder> {

    private FlashcardSet flashCardSet;

    private AdapterView.OnItemClickListener recoverButtonClick;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView flashCardTextRecycle;
        private final Button recoverButton;

        public ViewHolder(View view, FlashcardSet flashCardSet) {
            super(view);
            // Define click listener for the ViewHolder's View
            flashCardTextRecycle = (TextView) view.findViewById(R.id.flashCardTextRecycle);
            recoverButton = (Button) view.findViewById(R.id.recoveryButton);

            //Clicking this will mark the corresponding flashcard as recovered
            // and it will not pop up as a flashcard in the recycle view until restored
            recoverButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //set the flashcard as deleted
                    Flashcard card = flashCardSet.getFlashCardById((String)recoverButton.getTag());
                    card.markRecovered();

                    //delete the views associated with that flashcard
                    ViewGroup parentView = ((ViewGroup) flashCardTextRecycle.getParent());
                    parentView.removeView(flashCardTextRecycle);
                    parentView.removeView(recoverButton);
                }
            });

        }// end of ViewHolder class

        public TextView getTextView() {
            return flashCardTextRecycle;
        }

        public Button recoverButton() {
            return recoverButton;
        }

    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param flashCards contain the flashcards the data to populate views to be used
     * by RecyclerView
     */
    public CardRecoverAdapter(FlashcardSet flashCards) {
        flashCardSet = flashCards;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recover_view, viewGroup, false);

        return new ViewHolder(view,flashCardSet);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Flashcard card = flashCardSet.getIndex(position);
        viewHolder.getTextView().setText(card.toString());
        viewHolder.recoverButton().setTag(card.getUuid());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return flashCardSet.size();
    }
}
