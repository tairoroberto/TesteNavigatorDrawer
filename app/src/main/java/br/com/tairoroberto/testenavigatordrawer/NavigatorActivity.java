package br.com.tairoroberto.testenavigatordrawer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

import java.util.ArrayList;
import java.util.List;


public class NavigatorActivity extends SherlockFragmentActivity implements ListView.OnItemClickListener {
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private List<String> fragments;
    private CharSequence title;
    private CharSequence titleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        //pegar o titulo da activity
        title = titleFragment = getTitle();

        //Habilita o botão de voltar de cima na actionBar
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        fragments = new ArrayList<String>();
        fragments.add("Fragment 1");
        fragments.add("Fragment 2");
        fragments.add("Fragment 3");

        //pega o listView do xml
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this,fragments));
        listView.setOnItemClickListener(this);

        //pega o drawerLayout do xml
        drawerLayout = (DrawerLayout)findViewById(R.id.draweLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_drawer,R.string.toggle_open,R.string.toggle_close){

        };
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                actionBar.setTitle(titleFragment);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                actionBar.setTitle(title);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        //Verifica se saveInstanceState é null
        if (savedInstanceState == null){
            selectedItem(0);
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.menu_navigator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (actionBarDrawerToggle.onOptionsItemSelected(getCorrectMenuItem(item))){
            return true;
        }else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean status = drawerLayout.isDrawerOpen(listView);
        menu.findItem(R.id.action_settings).setVisible(!status);
        return super.onPrepareOptionsMenu(menu);
    }

    private android.view.MenuItem getCorrectMenuItem(final MenuItem item){
        return (new android.view.MenuItem() {
            @Override
            public int getItemId() {
                return item.getItemId();
            }

            @Override
            public int getGroupId() {
                return 0;
            }

            @Override
            public int getOrder() {
                return 0;
            }

            @Override
            public android.view.MenuItem setTitle(CharSequence title) {
                return null;
            }

            @Override
            public android.view.MenuItem setTitle(int title) {
                return null;
            }

            @Override
            public CharSequence getTitle() {
                return null;
            }

            @Override
            public android.view.MenuItem setTitleCondensed(CharSequence title) {
                return null;
            }

            @Override
            public CharSequence getTitleCondensed() {
                return null;
            }

            @Override
            public android.view.MenuItem setIcon(Drawable icon) {
                return null;
            }

            @Override
            public android.view.MenuItem setIcon(int iconRes) {
                return null;
            }

            @Override
            public Drawable getIcon() {
                return null;
            }

            @Override
            public android.view.MenuItem setIntent(Intent intent) {
                return null;
            }

            @Override
            public Intent getIntent() {
                return null;
            }

            @Override
            public android.view.MenuItem setShortcut(char numericChar, char alphaChar) {
                return null;
            }

            @Override
            public android.view.MenuItem setNumericShortcut(char numericChar) {
                return null;
            }

            @Override
            public char getNumericShortcut() {
                return 0;
            }

            @Override
            public android.view.MenuItem setAlphabeticShortcut(char alphaChar) {
                return null;
            }

            @Override
            public char getAlphabeticShortcut() {
                return 0;
            }

            @Override
            public android.view.MenuItem setCheckable(boolean checkable) {
                return null;
            }

            @Override
            public boolean isCheckable() {
                return false;
            }

            @Override
            public android.view.MenuItem setChecked(boolean checked) {
                return null;
            }

            @Override
            public boolean isChecked() {
                return false;
            }

            @Override
            public android.view.MenuItem setVisible(boolean visible) {
                return null;
            }

            @Override
            public boolean isVisible() {
                return false;
            }

            @Override
            public android.view.MenuItem setEnabled(boolean enabled) {
                return null;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean hasSubMenu() {
                return false;
            }

            @Override
            public android.view.SubMenu getSubMenu() {
                return null;
            }

            @Override
            public android.view.MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
                return null;
            }

            @Override
            public ContextMenu.ContextMenuInfo getMenuInfo() {
                return null;
            }

            @Override
            public void setShowAsAction(int actionEnum) {

            }

            @Override
            public android.view.MenuItem setShowAsActionFlags(int actionEnum) {
                return null;
            }

            @Override
            public android.view.MenuItem setActionView(View view) {
                return null;
            }

            @Override
            public android.view.MenuItem setActionView(int resId) {
                return null;
            }

            @Override
            public View getActionView() {
                return null;
            }

            @Override
            public android.view.MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
                return null;
            }

            @Override
            public android.view.ActionProvider getActionProvider() {
                return null;
            }

            @Override
            public boolean expandActionView() {
                return false;
            }

            @Override
            public boolean collapseActionView() {
                return false;
            }

            @Override
            public boolean isActionViewExpanded() {
                return false;
            }

            @Override
            public android.view.MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
                return null;
            }
        });
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectedItem(position);
    }

    private void selectedItem(int position){
        FragmentTransaction fragmentTransaction;
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new Fragment1();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragment = new Fragment2();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragment = new Fragment3();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fragment);
                fragmentTransaction.commit();
                break;
        }

        listView.setItemChecked(position,true);
        setCustomTitle(fragments.get(position));
        drawerLayout.closeDrawer(listView);
    }

    private void setCustomTitle(String title){
        actionBar.setTitle(title);
        this.title = title;
    }
}
