package com.rohit.lpregister;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener{

    private EditText mEditTextFirstName,mEditTextLastName,mEditTextEmail,mEditTextMobile,mEditTextDob;
    ;

    private TextInputEditText mTextInputEditTextPassword, mTextInputEditTextConfirmPassword;

    private Button mButtonRegister;

    private TextView mTextViewAlreadyMember;

    // ImageView Instance Variable
    private ImageView mImageViewCandidateImage;

    // RadioGroup object Declaration.
    private RadioGroup mRadioGroupGender;

    // RadioButton object Declaration.
    private RadioButton mRadioButton;

    private InputValidation mInputValidation;


    String  mRegisterGender;

    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


         initView(); // initView() method call

        clickListener(); // clickListener(); method call

        initObject(); // initObject method call

    }

    /**
     * clickListener() method definition
      */

    private void clickListener() {
        mButtonRegister.setOnClickListener(this);

        mTextViewAlreadyMember.setOnClickListener(this);

        mImageViewCandidateImage.setOnClickListener(this);

        mRadioGroupGender.setOnCheckedChangeListener(this);
    }

    /**
     * intiView Method definition
     */
    private void initView() {

        mEditTextFirstName = findViewById(R.id.editText_first_name);
        mEditTextLastName = findViewById(R.id.editText_last_name);
        mEditTextEmail = findViewById(R.id.editText_email);
        mEditTextMobile = findViewById(R.id.editText_mobile_number);
        mTextInputEditTextPassword = findViewById(R.id.editText_password);
        mTextInputEditTextConfirmPassword = findViewById(R.id.editText_confirm_password);
        mEditTextDob = findViewById(R.id.editText_dob);

        mButtonRegister = findViewById(R.id.button_register);

        mTextViewAlreadyMember = findViewById(R.id.textView_already_member);

        mImageViewCandidateImage = findViewById(R.id.imageView);

        mRadioGroupGender = findViewById(R.id.radioGroupP_gender);

        mRelativeLayout = findViewById(R.id.relative_layout);

    }

    public void initObject(){

        mInputValidation = new InputValidation(this);
    }

    /**
     * OnClick() method implementation
      * @param view as a parameter
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button_register:

                inputFieldValidation();

                break;

            case R.id.textView_already_member:
                break;

            case R.id.imageView:
                break;
        }

    }

    /**
     * getData() method definition
      */
    public void getData(){

        StringBuilder sb = new StringBuilder();

        sb.append(mEditTextFirstName.getText().toString().trim());
        sb.append("  ");
        sb.append(mEditTextLastName.getText().toString().trim());
        sb.append("  ");
        sb.append(mEditTextEmail.getText().toString().trim());
        sb.append("  ");
        sb.append(mEditTextMobile.getText().toString().trim());
        sb.append("  ");
        sb.append(mEditTextDob.getText().toString().trim());
        sb.append("  ");
        sb.append(Objects.requireNonNull(mTextInputEditTextPassword.getText()).toString().trim());
        sb.append("  ");
        sb.append(Objects.requireNonNull(mTextInputEditTextConfirmPassword.getText()).toString().trim());

        if (mRadioGroupGender != null) {

            mRegisterGender = mRadioButton.getText().toString().trim();
            sb.append("  ");
            sb.append(mRegisterGender);
        }


        Toast.makeText(this, sb, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        // getting the checked button id.
        mRadioButton = (RadioButton) group.findViewById(checkedId);
    }

    public void inputFieldValidation() {

        // Checking the First Name Field
        if (mInputValidation.isInputEditTextFilled(mEditTextFirstName, "First Name Required")) {
            return;
        }
        // Checking the Last Name Field
        if (mInputValidation.isInputEditTextFilled(mEditTextLastName, "Last Name Required")) {
            return;
        }

        // Checking the Email Field
        if (mInputValidation.isInputEditTextEmail(mEditTextEmail)) {
            return;
        }

        // Checking the Mobile Number Field
        if (mInputValidation.isInputEditTextFilled(mEditTextMobile, "Mobile Number Required")) {
            return;
        }

        // Checking the DOB Field
        if (mInputValidation.isInputEditTextFilled(mEditTextDob, "DOB Required")) {
            return;
        }

        // Checking the RadioButton
        if (mInputValidation.isRadioButtonSelected(mRadioGroupGender, mRelativeLayout)) {
            return;
        }



        // Checking the Password Field
        if (mInputValidation.isInputTextInputEditTextFilled(mTextInputEditTextPassword, "Password Required")) {
            return;
        }

        // Checking the Confirm Password field Field
        if (mInputValidation.isInputTextInputEditTextFilled(mTextInputEditTextConfirmPassword, "Confirm Password  Required")) {
            return;
        }


        // Checking the matching both password Field
        if (mInputValidation. isTextInputEditTextPasswordMatches(mTextInputEditTextPassword, mTextInputEditTextConfirmPassword)) {
            return;
        }


               getData();   //getData() method call


    }
}
