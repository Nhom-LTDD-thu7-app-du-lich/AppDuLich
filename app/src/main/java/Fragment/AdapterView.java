package Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterView extends FragmentStatePagerAdapter {
    public AdapterView(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_Trangchu();
            case 1:
                return new Fragment_Login();
            case 2:
                return new Fragment_ListTour();
            default:
                return new Fragment_Trangchu();

        }

    }

    @Override
    public int getCount() {
        return 3;
    }


}
