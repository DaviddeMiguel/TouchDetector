# TouchDetector
A framework used to detect all touch events in the screen with a single line in your code `TouchDetector.bind(this);`

##Usage
````

public class LoginActivity extends AppCompatActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    TouchDetector.bind(this);
  }
}

````

##Setup
- Add the module `touch-detector-core` to your project
- Add `compile project(':touch-detector-core')` to your `build.gradle` file

####Gradle (not available yet)
- Add `compile 'com.github.DaviddeMiguel:touch-detector-core:0.0.1'` to your `build.gradle` file

####Maven (not available yet)
````
<dependency>
    <groupId>com.github.lawloretienne</groupId>
    <artifactId>trestle</artifactId>
    <version>0.0.7</version>
</dependency>
````


````
Copyright 2016 David de Miguel Galán

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
