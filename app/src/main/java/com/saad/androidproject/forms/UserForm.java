package com.saad.androidproject.forms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.saad.androidproject.R;
import com.saad.androidproject.retrofit.APIClient;
import com.saad.androidproject.retrofit.APIInterface;
import com.saad.androidproject.retrofit.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserForm extends Fragment {

    ProgressBar progressBar;
    Button submitBtn;
    EditText nameTxt;
    EditText jobTxt;

    APIInterface apiInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        nameTxt = view.findViewById(R.id.name);
        jobTxt = view.findViewById(R.id.job);
        submitBtn = view.findViewById(R.id.submit);

        submitBtn.setOnClickListener(v -> {
            User user = new User(nameTxt.getText().toString(), jobTxt.getText().toString());
            Call<User> createUser = apiInterface.createUser(user);
            createUser.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    System.out.println(response);
                    Toast.makeText(getContext(), "User created successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(getContext(), "Failed to create user", Toast.LENGTH_SHORT).show();
                }
            });
        });
        return view;
    }

//    public static class CreateUserFragment extends Fragment {
//
//        private LoginViewModel loginViewModel;
//        private FragmentCreateUserBinding binding;
//
//        @Nullable
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater,
//                                 @Nullable ViewGroup container,
//                                 @Nullable Bundle savedInstanceState) {
//
//            binding = FragmentCreateUserBinding.inflate(inflater, container, false);
//            return binding.getRoot();
//
//        }
//
//        @Override
//        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//            super.onViewCreated(view, savedInstanceState);
//            loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
//                    .get(LoginViewModel.class);
//
//            final EditText usernameEditText = binding.username;
//            final EditText passwordEditText = binding.password;
//            final Button loginButton = binding.login;
//            final ProgressBar loadingProgressBar = binding.loading;
//
//            loginViewModel.getLoginFormState().observe(getViewLifecycleOwner(), new Observer<LoginFormState>() {
//                @Override
//                public void onChanged(@Nullable LoginFormState loginFormState) {
//                    if (loginFormState == null) {
//                        return;
//                    }
//                    loginButton.setEnabled(loginFormState.isDataValid());
//                    if (loginFormState.getUsernameError() != null) {
//                        usernameEditText.setError(getString(loginFormState.getUsernameError()));
//                    }
//                    if (loginFormState.getPasswordError() != null) {
//                        passwordEditText.setError(getString(loginFormState.getPasswordError()));
//                    }
//                }
//            });
//
//            loginViewModel.getLoginResult().observe(getViewLifecycleOwner(), new Observer<LoginResult>() {
//                @Override
//                public void onChanged(@Nullable LoginResult loginResult) {
//                    if (loginResult == null) {
//                        return;
//                    }
//                    loadingProgressBar.setVisibility(View.GONE);
//                    if (loginResult.getError() != null) {
//                        showLoginFailed(loginResult.getError());
//                    }
//                    if (loginResult.getSuccess() != null) {
//                        updateUiWithUser(loginResult.getSuccess());
//                    }
//                }
//            });
//
//            TextWatcher afterTextChangedListener = new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                    // ignore
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    // ignore
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString());
//                }
//            };
//            usernameEditText.addTextChangedListener(afterTextChangedListener);
//            passwordEditText.addTextChangedListener(afterTextChangedListener);
//            passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//
//                @Override
//                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                    if (actionId == EditorInfo.IME_ACTION_DONE) {
//                        loginViewModel.login(usernameEditText.getText().toString(),
//                                passwordEditText.getText().toString());
//                    }
//                    return false;
//                }
//            });
//
//            loginButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    loadingProgressBar.setVisibility(View.VISIBLE);
//                    loginViewModel.login(usernameEditText.getText().toString(),
//                            passwordEditText.getText().toString());
//                }
//            });
//        }
//
//        private void updateUiWithUser(LoggedInUserView model) {
//            String welcome = getString(R.string.welcome) + model.getDisplayName();
//            // TODO : initiate successful logged in experience
//            if (getContext() != null && getContext().getApplicationContext() != null) {
//                Toast.makeText(getContext().getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
//            }
//        }
//
//        private void showLoginFailed(@StringRes Integer errorString) {
//            if (getContext() != null && getContext().getApplicationContext() != null) {
//                Toast.makeText(
//                        getContext().getApplicationContext(),
//                        errorString,
//                        Toast.LENGTH_LONG).show();
//            }
//        }
//
//        @Override
//        public void onDestroyView() {
//            super.onDestroyView();
//            binding = null;
//        }
//    }
}
