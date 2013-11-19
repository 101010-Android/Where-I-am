package it.kytech.whereiam;

import java.util.HashMap;

import it.kytech.whereiam.dialogs.DialogInterface;
import it.kytech.whereiam.dialogs.UpdateDialog;

public class GeneralDialog {

    //WARNINGS
    public static final int DIALOG_UPDATE_ID=1;
    public static final int DIALOG_CONFIRM_ID=2;

    //ERRORS
    public static final int DIALOG_ERROR_ID=3;
    public static final int DIALOG_GPS_ERROR_ID=4;

    HashMap<Integer, DialogInterface> dialogs;

    public GeneralDialog(){
        dialogs =  new HashMap<Integer, DialogInterface>();
        loadDialogs();
    }

    private void loadDialogs(){
        dialogs.put(DIALOG_UPDATE_ID, new UpdateDialog());
    }
}

