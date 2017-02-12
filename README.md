![playbuzz logo](http://i68.tinypic.com/55o84j.png)

[![Support](https://img.shields.io/badge/contact-ShaiLevy-brightgreen.svg)](mailto:levyshai@gmail.com)
[![License: MIT](https://img.shields.io/badge/license-MIT-orange.svg)](https://github.com/orazz/CreditCardForm-iOS/blob/master/LICENSE)


## Get Started

The Playbuzz SDK enabled developers easily embed Playbuzz items in native apps.

## Prerequisites

- Android Studio 2+
- Android 4.0.3+

## Example

To check out the example, download the repo run the sample project.

# Add to project
Add it in your root `build.gradle` at the end of repositories:

``` groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
In your application gradle file add the dependency:

``` groovy
dependencies {
    compile 'com.github.Shailevy:PlaybuzzSDK:v1.0'
}
```

## Usage

The SDK provides you with an PlaybuzzWebView that works like any other WebView except when you want to load a Playbuzz item into it. 

``` xml
    <com.playbuzz.android.sdk.PlaybuzzWebView
        android:id="@+id/pbwebview"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

```

You'll need **itemAlies** - the url suffix of your item 

![url](http://i63.tinypic.com/1z35k7b.png)

In your code after you obtain the PlaybuzzWebView you should call it's 'loadItem(...)' function:

``` java
        PlaybuzzWebView pbWebView = (PlaybuzzWebView) findViewById(R.id.pbwebview);
        pbWebView.loadItem("http://www.example.com",
                "shpaltman/10-best-commercials-for-the-olympic-games-rio-2016",
                true);

```

1. **companyDomain** - the domain configered for your compony 
2. **itemAlies** - the url suffix of your item 
3. **showItemInfo** - show or hide item title and description

And that's it, The Playbuzz item will be rendred in the view you used



## License

PlaybuzzSDK for Android is available under the MIT license. See the LICENSE file for more info.
