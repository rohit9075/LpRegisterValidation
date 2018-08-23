package com.rohit.lpregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener{

    private EditText mEditTextFirstName,mEditTextLastName,mEditTextEmail,mEditTextMobile,mEditTextDob,mEditTextPassword,
    mEditTextConfirmPassword;

    private Button mButtonRegister;

    private TextView mTextViewAlreadyMember;

    private ImageView mImageViewCandidateImage;

    // RadioGroup object Declaration.
    private RadioGroup mRadioGroupGender;

    // RadioButton object Declaration.
    private RadioButton mRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // initView() method call
         initView();


         // clickListener(); method call
        clickListener();

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
        mEditTextPassword = findViewById(R.id.editText_password);
        mEditTextConfirmPassword = findViewById(R.id.editText_confirm_password);
        mEditTextDob = findViewById(R.id.editText_dob);

        mButtonRegister = findViewById(R.id.button_register);

        mTextViewAlreadyMember = findViewById(R.id.textView_already_member);

        mImageViewCandidateImage = findViewById(R.id.imageView);

        mRadioGroupGender = findViewById(R.id.radioGroup);
    }

    /**
     * OnClick() method implementation
      * @param view as a parameter
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button_register:
                getData();   //getData() method call
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
        sb.append(mEditTextPassword.getText().toString().trim());
        sb.append("  ");
        sb.append(mEditTextConfirmPassword.getText().toString().trim());

        if (mRadioGroupGender != null) {
            String  mRegisterGender = mRadioButton.getText().toString().trim();
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
}
