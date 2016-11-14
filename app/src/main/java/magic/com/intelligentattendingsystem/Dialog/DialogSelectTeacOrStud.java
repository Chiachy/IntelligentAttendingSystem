package magic.com.intelligentattendingsystem.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import magic.com.intelligentattendingsystem.Activity.ActivityStudentSignUp;
import magic.com.intelligentattendingsystem.Activity.ActivityTeacherSignUp;
import magic.com.intelligentattendingsystem.R;


public class DialogSelectTeacOrStud extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_select_identity_tip)
                .setItems(R.array.identity, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent intent = new Intent(getActivity(), ActivityTeacherSignUp.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(getActivity(), ActivityStudentSignUp.class);
                                startActivity(intent1);
                                break;
                            default:break;
                        }
                    }
                });
        return builder.create();
    }
}
