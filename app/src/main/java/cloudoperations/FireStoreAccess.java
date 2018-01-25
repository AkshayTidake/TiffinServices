package cloudoperations;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;

import model.DataModel;

public class FireStoreAccess extends Application {
    FirebaseFirestore db;
    Task<DocumentSnapshot> df;
    String email = "";
    Context ctx;

   private static int counter = 0;

    public FireStoreAccess(Context ctx) {
        this.ctx = ctx;
        db = FirebaseFirestore.getInstance();
    }

    public void registerUser(String nm,String snm,String em,String coun,String st,String ct,String ar,String cn,String pn,String ps){
        email = em;

        Map<String,Object> registerUser = new HashMap<>();
        registerUser.put("name",nm);
        registerUser.put("service_name",snm);
        registerUser.put("email",email);
        registerUser.put("country",coun);
        registerUser.put("state",st);
        registerUser.put("city",ct);
        registerUser.put("area",ar);
        registerUser.put("contact",cn);
        registerUser.put("pincode",pn);
        registerUser.put("password",ps);
        db.collection("tiffinregistration").document(email).set(registerUser).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ctx,"User Registered",Toast.LENGTH_LONG).show();
            }

        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ctx,"Error :"+e.toString(),Toast.LENGTH_LONG).show();
                    }
                });

    }

    public void readUser(final TextView tv){
        df = db.collection("tiffinregistration").document("akshaytidake0918@gmail.com").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    fields.append("service_name: ").append(doc.get("service_name"));
                    fields.append("\nAddress: ").append(doc.get("area")+","+doc.get("city")+","+doc.get("state")+","+doc.get("country"));
                    fields.append("\nemail: ").append(doc.get("email"));
                    fields.append("\ncontact: ").append(doc.get("contact"));
                    tv.setText(fields.toString());
            }
        }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ctx,"Error :"+e.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void deleteData(String mail){
        db.collection("tiffinregistration").document(mail)
                .delete().addOnSuccessListener(new OnSuccessListener < Void > () {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ctx, "Data deleted !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
