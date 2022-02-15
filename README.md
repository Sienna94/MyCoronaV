# :mask: MyCoronaV

> 코로나 검사 및 진료 가능한 병원 리스트를 제공하는 개인 프로젝트
>
> - 서울시에서 제공하는 확진자 정보 API를 사용하여 실시간 코로나 확진자 정보를 보여주는 개인 프로젝트였으나, 제공 API 중단으로 호흡기 진료 지정 의료기관 정보서비스 API로 교체

## 1. 제작 기간

- 2021.07 (2주)



## 2. 사용 기술

- ``Retrofit2``, `MVVM`, `ListView`, `GridView`, `ScrollView`, `ViewPager2`



## 3. 핵심 기능 및 구조

<img src="https://user-images.githubusercontent.com/69448123/154096395-0614d164-e0e0-421c-b770-b80b5104f1a1.png" alt="codit1-1" style="zoom:67%;" />

## 4. 트러블 슈팅

#### 4.1.  

#### 4.2. 기타

- **splash 화면**

  > 따로 ` SplashActivity`를 생성하지 않고 액티비티의 테마 배경을 변경하는 방식으로 구현하였습니다.
  >
  > **`themes.xml`**
  >
  > ```xml
  > <resources xmlns:tools="http://schemas.android.com/tools">
  >  ...
  >  <style name="SplashTheme" parent="Theme.AppCompat.NoActionBar">
  >      <item name="android:windowBackground">@drawable/splash</item>
  >  </style>
  > </resources>
  > ```
  >
  > 
  >
  > **`AndroidManifest.xml`**
  >
  > ```xml
  > <?xml version="1.0" encoding="utf-8"?>
  > <manifest xmlns:android="http://schemas.android.com/apk/res/android"
  >  package="com.example.mycoronav">
  > ...
  >      <activity android:name=".activity.MainActivity"
  >          android:theme="@style/SplashTheme">
  >          <intent-filter>
  >              <action android:name="android.intent.action.MAIN" />
  > 
  >              <category android:name="android.intent.category.LAUNCHER" />
  >          </intent-filter>
  >      </activity>
  >  </application>
  > 
  > </manifest>
  > ```
  >
  > 
  >
  > **`MainActivity.kt`**
  >
  > ```kotlin
  > class MainActivity : AppCompatActivity(), ListFragment.ListRequestListener,
  >  GridFragment.ListRequestListener, ScrollFragment.ListRequestListener {
  > ...
  > 
  >  override fun onCreate(savedInstanceState: Bundle?) {
  >      //after splash showed, set Theme default again
  >      setTheme(R.style.AppTheme)
  >      super.onCreate(savedInstanceState)
  >     ...
  >  }
  > ```
  >
  > - 참고 포스팅 :point_right:](https://lanace.github.io/articles/right-way-on-splash/)



## 5. 회고/ 느낀 점

- MVVM 패턴에 대한 잘못된 이해
  - 그냥 ViewModel 사용하고 LiveData로 데이터를 넣으면 된다고 생각함.
  - Model과 ViewModel을 제대로 분리하지 못한 아쉬움.

