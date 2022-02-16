# :mask: MyCoronaV

> 코로나 검사 및 진료 가능한 병원 리스트를 제공하는 개인 프로젝트
>
> - 서울시에서 제공하는 확진자 정보 API를 사용하여 실시간 코로나 확진자 정보를 보여주는 개인 프로젝트였으나, 제공 API 중단으로 호흡기 진료 지정 의료기관 정보서비스 API로 교체
> - *MVVM* , *ViewModel*, *DataBinding* 등의 개발도구 연습을 목적으로 제작 

## 1. 제작 기간

- 2021.07 (2주)



## 2. 사용 기술

- ``Retrofit2``, `MVVM`, `ListView`, `GridView`, `ScrollView`, `ViewPager2` 



## 3. 핵심 기능 및 구조

### 3.1. 핵심기능

<img src="https://user-images.githubusercontent.com/69448123/154096395-0614d164-e0e0-421c-b770-b80b5104f1a1.png" alt="codit1-1" style="zoom:67%;" />

- 코로나 검사 및 진료 가능한 병원 리스트를 제공
-  `LiveData` 사용 UI 업데이트
  -  `ListFragment`, `GridFragment`, `ScrollFragment` 이 데이터를 공유하며, 아이템 삭제시 실시간으로 모든 프래그먼트에 반영



### 3.2. 구조

- **MVVM(Model View View-Model)**

  <img src="https://user-images.githubusercontent.com/69448123/154233243-72a2305f-a486-4165-af8b-f540610eec5d.png" style="zoom:80%;" /> 





## 4. 트러블 슈팅

### 4.1.  Retrofit으로 XML 파싱 오류

> - API를 교체하는 과정에서 XML 컨버팅이 제대로 되지 않는 오류 발생
>   - `_Could not locate ResponseBody converter..._`
>
> - *Interceptor*를 통해 통신에 사용된 인증키가 잘못된 형태로 request되는 것을 확인
>   - 포털에서 제공되는 인증키 중 Decoding을 사용하여 해결 

### 4.3. 기타

- **splash 화면 구현**

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
  - 그냥 ViewModel 사용하고 LiveData로 데이터를 넣으면 되겠지하고 안일한 마음으로 임했습니다. Fragment와 Activity 간에서의 데이터 전달이 편해지겠지하는 단순한 마음에 시작했기 때문입니다.
  -  View와 ViewModel의 역할분리를 명확하게 구현하지 못한 점이 아쉽습니다.
- 최신 안드로이드 개발 도구를 목적으로 했기에, 다양한 기능을 구현하지 못한 것이 아쉽습니다.
- Http통신시 Interceptor를 통한 로그 확인의 중요성을 느꼈습니다.

