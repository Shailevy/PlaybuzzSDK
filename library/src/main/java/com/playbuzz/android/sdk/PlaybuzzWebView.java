package com.playbuzz.android.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PlaybuzzWebView extends WebView {
    public static final String EMBED_HTML = "<!DOCTYPE html><html> <meta name=\"viewport\" content=\"width=device-width\"/> <head></head><body><script type=\"text/javascript\" src=\"//cdn.playbuzz.com/widget/feed.js\"></script><div class=\"pb_feed\" data-game=\"%s\" data-game-info=\"%s\" data-platform=\"Android\" ></div></body></html>";

    public PlaybuzzWebView(Context context) {
        super(context);
    }

    public PlaybuzzWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlaybuzzWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PlaybuzzWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public PlaybuzzWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.setAcceptFileSchemeCookies(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().acceptThirdPartyCookies(this);
        }
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }

    /***
     *
     * @param companyDomain The company base url including http/https, usually points to the company homepage
     * @param itemAlias An item id tha can be obtained from the item url. "caralb10/do-you-know-the-results-of-super-tuesday for http://www.playbuzz.com/caralb10/do-you-know-the-results-of-super-tuesday
     * @param showItemInfo Pass true to show item name and desciption
     */
    public void loadItem(String companyDomain,
                         String itemAlias,
                         boolean showItemInfo) {
        String embedHtml = String.format(EMBED_HTML,
                itemAlias,
                showItemInfo ? "true" : "false");

        loadDataWithBaseURL(companyDomain, embedHtml, "text/html", "UTF-8", null);
    }
}
