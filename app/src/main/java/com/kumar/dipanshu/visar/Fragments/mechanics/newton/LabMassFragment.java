package com.kumar.dipanshu.visar.Fragments.mechanics.newton;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kumar.dipanshu.visar.R;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class LabMassFragment extends Fragment {


    public LabMassFragment() {
        // Required empty public constructor
    }

    String url = "https://labs.visar.co.za/gravity-force-lab/gravity-force-lab_en.html";
    WebView wvPage1;
    double PIC_WIDTH = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_lab_mass,container, false);

        ShowHideFullscreen(true,getContext());
        getActivity().setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        wvPage1 = (WebView)v.findViewById(R.id.webView);
        wvPage1.setPadding(0, 0, 0, 0);
        wvPage1.setInitialScale(10);
        wvPage1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        wvPage1.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wvPage1.setScrollbarFadingEnabled(false);
        wvPage1.getSettings().setLoadWithOverviewMode(true);
        wvPage1.getSettings().setUseWideViewPort(true);
        wvPage1.getSettings().setBuiltInZoomControls(true);
        //
        wvPage1.loadUrl(url);

        WebSettings settings = wvPage1.getSettings();
        settings.setJavaScriptEnabled(true);
        wvPage1.setWebViewClient(new LabMassFragment.MyWebViewClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        settings.setDomStorageEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);

        wvPage1.setWebChromeClient(new WebChromeClient(){
            // Need to accept permissions to use the camera
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request.grant(request.getResources());
                }
            }

        });


        return v;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            Activity a = getActivity();
            if(a != null) a.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    private int getScale() {
        Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();

        Double val = new Double(width)/new Double(PIC_WIDTH);
        val = val * 100d;
        return val.intValue();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final View decorView = getActivity().getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(
                new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int i) {
                        int height = decorView.getHeight();
                        Log.i(TAG, "Current height: " + height);
                    }
                });
    }

    //This method not showing transparent status bar also navigation bar and not showing system icons either
    public static void  setFullscreen(Activity activity) {
        if (Build.VERSION.SDK_INT > 10) {
            int flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_FULLSCREEN;
            boolean isImmersiveAvailable = android.os.Build.VERSION.SDK_INT >= 19;
            if (isImmersiveAvailable) {
                flags |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            }

            activity.getWindow().getDecorView().setSystemUiVisibility(flags);
        } else {
            activity.getWindow()
                    .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    public static void exitFullscreen(Activity activity) {
        if (Build.VERSION.SDK_INT > 10) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        } else {
            activity.getWindow()
                    .setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
    }


    public static void ShowHideFullscreen(boolean isFullscreen,Context cntx){
        int newUiOptions = 0;
        if (isFullscreen){
            // BEGIN_INCLUDE (get_current_ui_flags)
            // The UI options currently enabled are represented by a bitfield.
            // getSystemUiVisibility() gives us that bitfield.
            int uiOptions = ((Activity)cntx).getWindow().getDecorView().getSystemUiVisibility();
            newUiOptions = uiOptions;
            // END_INCLUDE (get_current_ui_flags)
            // BEGIN_INCLUDE (toggle_ui_flags)
            boolean isImmersiveModeEnabled =
                    ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
            if (isImmersiveModeEnabled) {
                Log.d(TAG, "Turning immersive mode mode off. ");
            } else {
                Log.d(TAG, "Turning immersive mode mode on.");
            }

            // Navigation bar hiding:  Backwards compatible to ICS.
            if (Build.VERSION.SDK_INT >= 14) {
                newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            }

            // Status bar hiding: Backwards compatible to Jellybean
            if (Build.VERSION.SDK_INT >= 16) {
                newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
            }

            // Immersive mode: Backward compatible to KitKat.
            // Note that this flag doesn't do anything by itself, it only augments the behavior
            // of HIDE_NAVIGATION and FLAG_FULLSCREEN.  For the purposes of this sample
            // all three flags are being toggled together.
            // Note that there are two immersive mode UI flags, one of which is referred to as "sticky".
            // Sticky immersive mode differs in that it makes the navigation and status bars
            // semi-transparent, and the UI flag does not get cleared when the user interacts with
            // the screen.
            if (Build.VERSION.SDK_INT >= 18) {
                newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            }
            ((Activity)cntx).getWindow().getDecorView().setSystemUiVisibility(newUiOptions);

        }else {
            ((Activity)cntx).getWindow().clearFlags(newUiOptions);

        }
    }



    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            final Uri uri = Uri.parse(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }


    }

}



