package com.aimsgroup.arls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            username = bundle.getString("username");
        }

    }



    public void myBusinessBtn(View view) {
        Intent i= new Intent(HomePageActivity.this, ProfilePageActivity.class);
        i.putExtra("username",username);
        startActivity(i);
    }

    public void shotMaterialsList(View view) {
        Intent i= new Intent(HomePageActivity.this, MaterialsChoice.class);
        i.putExtra("username",username);
        startActivity(i);
    }

    public void myWishList(View view) {
        Intent i= new Intent(HomePageActivity.this, MyWishLists.class);
        i.putExtra("username",username);
        startActivity(i);
    }

    public void bidOnMaterials(View view) {
        Intent i= new Intent(HomePageActivity.this, BidOnMaterials.class);
        i.putExtra("username",username);
        startActivity(i);
    }

    public void showMyPurchase(View view) {
        Intent i= new Intent(HomePageActivity.this, MyPurchase.class);
        i.putExtra("username",username);
        startActivity(i);
    }

    public void showMySales(View view) {
        Intent i= new Intent(HomePageActivity.this, MySales.class);
        i.putExtra("username",username);
        startActivity(i);
    }

    public void showMyPendingBids(View view) {
        Intent i= new Intent(HomePageActivity.this, MyPendingBids.class);
        i.putExtra("username",username);
        startActivity(i);
    }


    public void showMyVehicles(View view) {
    }

    public void showPaymentToken(View view) {
    }

    public void showDonationPage(View view) {
    }

    public void showStockVisiting(View view) {
    }

    public void showMyComplains(View view) {
    }

    public void showMyPendingOrders(View view) {
    }

    public void showReturnMaterials(View view) {
    }

    public void showReviewPage(View view) {
    }

    public void showAboutPage(View view) {
    }

    public void showMyWallet(View view) {
    }

    public void showDevelopersContact(View view) {
    }
}