package com.example.tp5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    List<Contact> contacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        contacts.add(new Contact("Jean","Pierre", "https://www.mediaspecs.fr/wp-content/uploads/2020/09/cover-jean-pierre-pernaut-jt-13h-58f17c-0@1x.jpg"));
        contacts.add(new Contact("Jeanne","D'arc", "https://histoire-image.org/sites/default/jeanne-arc-sacre-charlesvii.jpg"));
        contacts.add(new Contact("Pierre","Menez","https://th.bing.com/th?id=OIF.KnmQS%2bxcnDuQYR4B6UaMHA&pid=ImgDet&rs=1"));
        contacts.add(new Contact("Arthur","Rimbaut", "https://th.bing.com/th/id/OIP.9UT7LHiFajGzoeAn4uAxkQHaJr?pid=ImgDet&rs=1"));
        contacts.add(new Contact("Richard","Coeur de lion", "https://th.bing.com/th/id/R.1f0f4b64d3b6207daae8211e29801900?rik=b5v4PVaHDrJDFw&pid=ImgRaw&r=0"));
        contacts.add(new Contact("Zinedine","Zidane", "https://www.coleka.com/media/item/201806/27/france-98-zinedine-zidane-fra-164.jpg"));
        contacts.add(new Contact("Yannick","Noah", "https://th.bing.com/th/id/R.2a0808c766027b43514dfc7291be08af?rik=cIyUhG4WAZH4wg&riu=http%3a%2f%2fimg0.ndsstatic.com%2fyannick-noah%2fyannick-noah-est-de-nouveau-elu-personnalite-preferee-des-francais_133992_wide.jpg&ehk=aJYO5jXOzWF%2bAlqErW%2b%2fiGwmgV74uva8xpwCGhHsK7o%3d&risl=&pid=ImgRaw&r=0"));

        ContactsAdapter adapter = new ContactsAdapter(contacts);

        rvContacts.setAdapter(adapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}