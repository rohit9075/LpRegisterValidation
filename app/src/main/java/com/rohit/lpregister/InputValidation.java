package com.rohit.lpregister;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * InputValidation java class to validate the user input.
 */


public class InputValidation {

    // Instance variable
    private Context context;

    /**
     * constructor
     *
     * @param context Activity context
     */
    public InputValidation(Context context) {
        this.context = context;
    }

    /**
     * Checking the is TextInputEditText field is filled by the user or Empty
     *
     * @param editText View
     * @param message  String message passed form the calling class or method
     * @return Method is returning the boolean value
     */
    public boolean isInputEditTextFilled(EditText editText, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            Drawable customErrorDrawable = context.getResources().getDrawable(R.drawable.ic_error);
            customErrorDrawable.setBounds(0, 0, customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            editText.setError(message,customErrorDrawable);
            hideKeyboardFrom(editText);
            return false;
        }else {
            editText.setError(null);
            return true;
        }
    }


    /**
     * method to Hide keyboard
     *
     * @param view Widgets
     */
    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Method to check whether the radio button is checked or not
     *
     * @param gender  viewGroup
     * @param context Activity context
     * @return Method is returning the boolean value
     */
    public boolean isRadioButtonChecked(RadioGroup gender, Context context) {
        if (gender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(context, "Please select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Validating the email id
     *
     * @param editText view
     * @param message  error message provided by the calling method or class
     * @return This method is returning the boolean value
     */
    public boolean isInputEditTextEmail(EditText editText, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {

            Drawable customErrorDrawable = context.getResources().getDrawable(R.drawable.ic_error);
            customErrorDrawable.setBounds(0, 0, customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            editText.setError(message,customErrorDrawable);
            hideKeyboardFrom(editText);
            return false;
        } else {
            editText.setError(null);
            return true;
        }

    }


    /* *************************************** TextInputEditText Field Validation **************************************  */

    /**
     * @param textInputEditText view
     * @param message           this message will be provided by the calling method or class
     * @return method is returning boolean value
     */
    public boolean isInputTextInputEditTextFilled(TextInputEditText textInputEditText, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            Drawable customErrorDrawable = context.getResources().getDrawable(R.drawable.ic_error);
            customErrorDrawable.setBounds(0, 0, customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            textInputEditText.setError(message,customErrorDrawable);
            hideKeyboardFrom(textInputEditText);
            return false;
        }else {
            textInputEditText.setError(null);
            return true;
        }


    }

    /**
     * This method validates the entered password matched or not.
     * @param firstPassword first view
     * @param secondPassword second view
     * @param message error message
     * @return boolean
     */

    public boolean isTextInputEditTextPasswordMatches(TextInputEditText firstPassword, TextInputEditText secondPassword, String message) {
        String value1 = firstPassword.getText().toString().trim();
        String value2 = secondPassword.getText().toString().trim();
        if (!value1.contentEquals(value2)) {

            Drawable customErrorDrawable = context.getResources().getDrawable(R.drawable.ic_error);
            customErrorDrawable.setBounds(0, 0, customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            secondPassword.setError(message,customErrorDrawable);
            hideKeyboardFrom(secondPassword);
            return false;
        }
        else {
            secondPassword.setError(null);
            return true;
        }


    }

    /**
     * Method to check password length
     * @param passwordLength view
     * @param message message provided by the calling method or class
     * @return this method is returning the boolean value.
     */

    public boolean isPasswordLengthTextInputEditText(TextInputEditText passwordLength, String message) {
        String password = passwordLength.getText().toString().trim();
//        String pattern = "^(?=.*[0-9])(?=.*[!@#$%^&*+=?-]).{8,15}$";
        if(password.length()<=6) {

            Drawable customErrorDrawable = context.getResources().getDrawable(R.drawable.ic_error);
            customErrorDrawable.setBounds(0, 0, customErrorDrawable.getIntrinsicWidth(), customErrorDrawable.getIntrinsicHeight());
            passwordLength.setError(message,customErrorDrawable);
            hideKeyboardFrom(passwordLength);
            return false;
        }
        else {
            passwordLength.setError(null);
            return true;
        }
    }


    /**
     * This method validates the radiobutton selected or not
     * @param radioGroup viewGroup
     * @param message error message
     * @return boolean
     */

    public boolean isRadioButtonSelected(RadioGroup radioGroup, String message) {
        if ( radioGroup.getCheckedRadioButtonId() == -1) {

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
