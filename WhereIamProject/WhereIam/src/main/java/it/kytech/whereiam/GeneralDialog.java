package it.kytech.whereiam;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;

import java.util.HashMap;

import it.kytech.whereiam.dialogs.UpdateDialog;

public class GeneralDialog {

    //WARNINGS
    public static final int DIALOG_UPDATE_ID=1;
    public static final int DIALOG_CONFIRM_ID=2;

    //ERRORS
    public static final int DIALOG_ERROR_ID=3;
    public static final int DIALOG_GPS_ERROR_ID=4;

    private static GeneralDialog instance = new GeneralDialog();

    private HashMap<Integer, DialogInterface> dialogs;

    public GeneralDialog(){
        dialogs =  new HashMap<Integer, DialogInterface>();
        loadDialogs();
    }

    public static GeneralDialog getIstance(){
        return instance;
    }

    private void loadDialogs(){
        dialogs.put(new Integer(DIALOG_UPDATE_ID), new UpdateDialog());
    }

    public DialogFragment getDialog(int i){
        return (DialogFragment) dialogs.get(i);
    }
}

