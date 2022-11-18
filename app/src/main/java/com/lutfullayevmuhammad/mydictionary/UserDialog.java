package com.lutfullayevmuhammad.mydictionary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

public class UserDialog extends AlertDialog {

    View view;

    private EditText enDialog, uzDialog;

    private OnSaveButtonClick onSaveButtonClick;

    private Button saveBtn;

    public UserDialog(@NonNull Context context) {
        super(context);

        Window window = getWindow();

        window.getDecorView().setBackgroundColor(Color.TRANSPARENT);

        view = LayoutInflater.from(context).inflate(R.layout.user_dialog, null, false);

        setView(view);

        setup(context);

    }

    public void setOnSaveButtonClick(OnSaveButtonClick onSaveButtonClick) {
        this.onSaveButtonClick = onSaveButtonClick;
    }

    private void setup(Context context) {

        enDialog = view.findViewById(R.id.en_dialog);
        uzDialog = view.findViewById(R.id.uz_dialog);

        saveBtn = view.findViewById(R.id.save_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String en = enDialog.getText().toString();
                String uz = uzDialog.getText().toString();

                if (onSaveButtonClick != null) {
                    onSaveButtonClick.onSaveClick(en+" - "+uz);
                }

                dismiss();
                closeOptionsMenu();
            }
        });
    }


    public interface OnSaveButtonClick {
        void onSaveClick(String dictionary);
    }


}
