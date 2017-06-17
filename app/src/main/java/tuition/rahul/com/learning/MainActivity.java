package tuition.rahul.com.learning;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tuition.rahul.com.learning.BottomBar.bottombar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FirebaseAuth mAuth;
    public static String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mAuth= FirebaseAuth.getInstance();
        Log.d(TAG,"Signed out");
        Button signout= (Button) findViewById(R.id.signout);
Button go_to_bottom= (Button) findViewById(R.id.bottom);
        go_to_bottom.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAuth.signOut();
        Log.d(TAG,"Signed out");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mAuth.signOut();
        Log.d(TAG,"Signed out");
    }

    @Override
    public void onClick(View v) {
        int i=v.getId();
        if(R.id.signout==i){
            LoginManager.getInstance().logOut();
        }
        else if(R.id.bottom==i){
            Intent intent=new Intent(this,bottombar.class);
            startActivity(intent);
        }

    }
}
