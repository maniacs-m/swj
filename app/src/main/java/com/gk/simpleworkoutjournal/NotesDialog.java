package com.gk.simpleworkoutjournal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NotesDialog extends Activity {
		public static final  String APP_NAME = "SWJournal";
		EditText noteEdit;
		Intent notesIntent;
		String note;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			Log.v(APP_NAME, "Creating NotesDialog");
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.note_edit_dialog);
	        
	        noteEdit = (EditText) findViewById( R.id.noteDialogEditText );
	        notesIntent =  getIntent();
	        
	        //since header have width max of 21 symbols - set first 19 symbols to tex and three dots to show trimming
	        String header = notesIntent.getStringExtra("headText");
	        if ( header.length() >= 19 ) {
	        	header = header.subSequence(0, 18) + "...";
	        }
	        setTitle( header );
	        note = notesIntent.getStringExtra("note");
	        noteEdit.setText( note );
	        return ;
		}
		
		public void noteButtonClick(View v) {
			Log.v(APP_NAME, "button pressed in note edit");
			String newNote = noteEdit.getText().toString();
			if ( ( v.getId() == R.id.note_dialog_OK ) && newNote != note ) {
				notesIntent.putExtra( "note", newNote );
				setResult(RESULT_OK, notesIntent);
			} else {
				setResult(RESULT_CANCELED, null);
			}
			finish();
		}
		
}
