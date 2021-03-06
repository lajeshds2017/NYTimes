# NewYork Times Android Application in Kotlin

# Highlights

1. MVVM Architectural pattern
2. Unit test demonstration using JUnit and Mockito
3. UI unit test demonstartion using Espresso
4. Gradle scripts for running sonarqube static code analysis, code coverage, etc.


The application has been designed using **Android Architecture components** and **Data Binding**

The whole application is built based on the MVVM architectural pattern.

# Application Architecture
![alt text](http://images.zoftino.com/development/android-dev/library/model-view-viewmodel-pattern.png)

The main advatage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the datachanges in the viewmodel as we are using LiveData which is lifecycle aware. The viewmodel to view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).

# Screenshots
<img src="/screenshots/listing.png" width="346" height="615" alt="Home"/> 
<img src="/screenshots/details.png" width="346" height="615" alt="Home"/>


# Programming Practices Followed
a) Android Architectural Components <br/>
b) Dagger 2 for Dependency Injection <br/>
c) MVVM <br/>
d) Retrofit with Okhttp <br/>
e) JUnit and Mockito for Unit testing <br/>
f) Repository pattern for Data Layer <br/>

# How to build ?

Open terminal and type the below command to generate debug build <br/>

``` ./gradlew assembleDebug ```

Open terminal and type the below command to generate release build <br/>

``` ./gradlew assembleRelease ```

# How to generate Sonarqube report ?

Open gradle.properties and update the below line with the sonarqube server url

```systemProp.sonar.host.url=http://localhost:9000```

Before running the sonarqube job, make sure the project version has been updated in the build.gradle. On every run, increment the version by 1.<br/>

```
            property "sonar.sources", "src/main"
            property "sonar.projectName", "NYTimesApp" // Name of your project
            property "sonar.projectVersion", "1.0.0" // Version of your project
            property "sonar.projectDescription", "NYTimes Application to list popular Articles"
```

For running the sonarqube job, type the below command in the terminal. <br/>

```./gradlew sonarqube assembleDebug```

<br/>

# How to generate code coverage report ?

Open terminal and type the following command

```./gradlew clean jacocoTestReport```

The coverage report will be generated on the following path.

``` app/build/reports ```

# How to generate lint reports ?

Open terminal and type the following command
``` ./gradlew lint```

The lint report will be generated on the following path.
``` app/build/reports ```

