# nazk-client
Java client for declarations from the nazk.gov.ua.

[![Maven Central](https://img.shields.io/maven-central/v/com.github.javadev/nazk-client.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.javadev%22%20AND%20a%3A%22nazk-client%22)
[![Build Status](https://secure.travis-ci.org/javadev/nazk-client.svg)](https://travis-ci.org/javadev/nazk-client)

### Installation

Include the following in your `pom.xml` for Maven:

```xml
<dependencies>
  <dependency>
    <groupId>com.github.javadev</groupId>
    <artifactId>nazk-client</artifactId>
    <version>1.2</version>
  </dependency>
  ...
</dependencies>
```

Gradle:

```groovy
compile 'com.github.javadev:nazk-client:1.2'
```

Declaration request example:

```java
import com.github.javadev.nazk.client.HttpClient;
import com.github.javadev.nazk.client.NazkClient;
import java.util.Map;
import com.github.underscore.lodash.$;

public class Main {
    public static void main(String[] args) {
        NazkClient client = HttpClient.createDefault();
        Map<String, Object> declaration = client.getDeclaration("043c6b5d-a470-4fb0-bc3b-3332af7fe10e");
        System.out.println($.toJson(declaration));
    }
}
```

Output:
```javascript
{
  "id": "043c6b5d-a470-4fb0-bc3b-3332af7fe10e",
  "created_date": "21.10.2016",
  "lastmodified_date": "21.10.2016",
  "certificate_sign": "MIIqYgYJKoZIhvcNAQcCoIIqUzCCKk8CAQExDjAMBgoqhiQCAQEBAQIBMIIaCgYJKoZIhvcNAQcBoIIZ+wSCGfd7IjAiOnsiZGF0YSI6eyJkZWNsYXJhdGlvblR5cGUiOiIxIiwiZGVjbGFyYXRpb25ZZWFyMSI6IjIwMTUifX0sIjEiOnsiZGF0YSI6eyJsYXN0bmFtZSI6ItCd0LXQs9GW0L3RgdGM0LrQuNC5IiwiZmlyc3RuYW1lIjoi0IbQs9C+0YAiLCJtaWRkbGVuYW1lIjoi0JLQvtC70L7QtNC40LzQuNGA0L7QstC40YciLCJjaGFuZ2VkTmFtZSI6ZmFsc2UsInByZXZpb3VzX2xhc3RuYW1lIjoiIiwicHJldmlvdXNfZmlyc3RuYW1lIjoiIiwicHJldmlvdXNfbWlkZGxlbmFtZSI6IiIsImNvdW50cnkiOiIxIiwiY291bnRyeVBhdGgiOiIiLCJjaXR5VHlwZSI6ItCe0LTQtdGB0LAgLyDQntC00LXRgdGM0LrQsCDQntCx0LvQsNGB0YLRjCAvINCj0LrRgNCw0ZfQvdCwIiwiY2l0eVBhdGgiOiIxLjIuNTEuMS4xIiwic3RyZWV0VHlwZSI6ItCy0YPQu9C40YbRjyIsInN0cmVldCI6ItCb0Y7RgdGC0LTQvtGA0YTRgdGM0LrQsCDQtNC+0YDQvtCz0LAiLCJwb3N0Q29kZSI6IjY1MTEzIiwic2FtZVJlZ0xpdmluZ0FkZHJlc3MiOmZhbHNlLCJhY3R1YWxfY2l0eVR5cGUiOiLQp9C+0L8gLyDQl9Cw0LrQsNGA0L\/QsNGC0YHRjNC60LAg0J7QsdC70LDRgdGC0YwgLyDQo9C60YDQsNGX0L3QsCIsImFjdHVhbF9zdHJlZXRUeXBlIjoi0LLRg9C70LjRhtGPIiwiYWN0dWFsX3N0cmVldCI6ItCc0LjRgNGDIiwiYWN0dWFsX3Bvc3RDb2RlIjoiODk1MDIiLCJlbmdfc2FtZVJlZ0xpdmluZ0FkZHJlc3MiOiIiLCJlbmdfcG9zdENvZGUiOiIiLCJlbmdfYWN0dWFsUG9zdENvZGUiOiIiLCJ3b3JrUGxhY2UiOiLQl9Cw0LrQsNGA0L\/QsNGC0YHRjNC60LAg0LzQuNGC0L3QuNGG0Y8g0JTQpNChIiwid29ya1Bvc3QiOiLQndCw0YfQsNC70YzQvdC40Log0LzQuNGC0L3QvtCz0L4g0L\/QvtGB0YLRgyIsInBvc3RUeXBlIjoi0J\/QvtGB0LDQtNCwINC00LXRgNC20LDQstC90L7RlyDRgdC70YPQttCx0LgiLCJwb3N0Q2F0ZWdvcnkiOiLQkSIsInJlc3BvbnNpYmxlUG9zaXRpb24iOiLQlNC10YDQttCw0LLQvdC40Lkg0YHQu9GD0LbQsdC+0LLQtdGG0YwsINC\/0L7RgdCw0LTQsCDRj9C60L7Qs9C+INC90LDQu9C10LbQuNGC0Ywg0LTQviDQv9C+0YHQsNC0INC00LXRgNC20LDQstC90L7RlyDRgdC70YPQttCx0Lgg0LrQsNGC0LXQs9C+0YDRltGXICfQkCcg0LDQsdC+ICfQkSciLCJjb3JydXB0aW9uQWZmZWN0ZWQiOiLQndGWIiwicmVnaW9uIjoiMS4yLjUxIiwiZGlzdHJpY3QiOiIxLjIuNTEuMS4xIiwiYWN0dWFsX2NvdW50cnkiOiIxIiwiYWN0dWFsX3JlZ2lvbiI6IjEuMi4yMSIsImFjdHVhbF9kaXN0cmljdCI6IjEuMi4yMS4xLjEwIiwiYWN0dWFsX2NpdHlQYXRoIjoiMS4yLjIxLjEuMTAiLCJhY3R1YWxfaG91c2VQYXJ0TnVtX2V4dGVuZGVkc3RhdHVzIjoiMSJ9fSwiMiI6eyJkYXRhIjp7IjE0NzcwNzEzMDcyOTMiOnsiaXNOb3RBcHBsaWNhYmxlIjoiIiwic3ViamVjdFJlbGF0aW9uIjoi0LTQvtGH0LrQsCIsImxhc3RuYW1lIjoi0J3QtdCz0ZbQvdGB0YzQutCwIiwiZmlyc3RuYW1lIjoi0JrQsNGA0LjQvdCwIiwibWlkZGxlbmFtZSI6ItCG0LPQvtGA0ZbQstC90LAiLCJjaGFuZ2VkTmFtZSI6ZmFsc2UsInByZXZpb3VzX2xhc3RuYW1lIjoiIiwicHJldmlvdXNfZmlyc3RuYW1lIjoiIiwicHJldmlvdXNfbWlkZGxlbmFtZSI6IiIsImNpdGl6ZW5zaGlwIjoiMSIsImVuZ19sYXN0bmFtZSI6IiIsImVuZ19maXJzdG5hbWUiOiIiLCJlbmdfbWlkZGxlbmFtZSI6IiIsInByZXZpb3VzX2VuZ19sYXN0bmFtZSI6IiIsInByZXZpb3VzX2VuZ19maXJzdG5hbWUiOiIiLCJwcmV2aW91c19lbmdfbWlkZGxlbmFtZSI6IiIsIm5vX3RheE51bWJlciI6ZmFsc2V9fX0sIjMiOnsiaXNOb3RBcHBsaWNhYmxlIjowLCJkYXRhIjp7IjE0NzY1MTc1Njk0NTgiOnsicGVyc29uIjoiMSIsIm9iamVjdFR5cGUiOiLQl9C10LzQtdC70YzQvdCwINC00ZbQu9GP0L3QutCwIiwib3RoZXJPYmplY3RUeXBlIjoiIiwidG90YWxBcmVhIjoiNTU5Iiwib3duaW5nRGF0ZSI6IjE3LjA4LjIwMDkiLCJjb3N0RGF0ZSI6IiIsImNvc3RBc3Nlc3NtZW50IjoiIiwiY291bnRyeSI6IjEiLCJ1YV9wb3N0Q29kZSI6IjY3NDQzIiwicmVnaW9uIjoiMS4yLjUxIiwiZGlzdHJpY3QiOiIxLjIuNTEuMi4zOSIsImNpdHkiOiIxLjIuNTEuMi4zOS44LjE3LjEuNCIsInVhX2NpdHlUeXBlIjoi0JHRg9GA0LTRltCy0LrQsCAvINCg0L7Qt9C00ZbQu9GM0L3Rj9C90YHRjNC60LjQuSDQoNCw0LnQvtC9IC8g0J7QtNC10YHRjNC60LAg0J7QsdC70LDRgdGC0YwgLyDQo9C60YDQsNGX0L3QsCIsImNpdHlQYXRoIjoiMS4yLjUxLjIuMzkuOC4xNy4xLjQiLCJ1YV9zdHJlZXRUeXBlIjoi0LLRg9C70LjRhtGPIiwidWFfc3RyZWV0IjoiIiwicG9zdENvZGUiOiIiLCJyaWdodHMiOnsiMSI6eyJvd25lcnNoaXBUeXBlIjoi0JLQu9Cw0YHQvdGW0YHRgtGMIiwib3RoZXJPd25lcnNoaXAiOiIiLCJwZXJjZW50LW93bmVyc2hpcCI6IiIsInJpZ2h0QmVsb25ncyI6IjEiLCJjaXRpemVuIjoiIiwidWFfY2l0eSI6IiIsInJpZ2h0c19jaXR5UGF0aCI6IiIsInVhX2xhc3RuYW1lIjoiIiwidWFfZmlyc3RuYW1lIjoiIiwidWFfbWlkZGxlbmFtZSI6IiIsInVhX3N0cmVldFR5cGUiOiIiLCJ1YV9zdHJlZXQiOiIiLCJ1YV9wb3N0Q29kZSI6IiIsInVhX2NvbXBhbnlfbmFtZSI6IiIsImVuZ19sYXN0bmFtZSI6IiIsImVuZ19maXJzdG5hbWUiOiIiLCJlbmdfbWlkZGxlbmFtZSI6IiIsInVrcl9sYXN0bmFtZSI6IiIsInVrcl9maXJzdG5hbWUiOiIiLCJ1a3JfbWlkZGxlbmFtZSI6IiIsImVuZ19wb3N0Q29kZSI6IiIsImVuZ19jb21wYW55X25hbWUiOiIiLCJ1a3JfY29tcGFueV9uYW1lIjoiIiwidWFfbWlkZGxlbmFtZV9leHRlbmRlZHN0YXR1cyI6IiIsInVhX3N0cmVldF9leHRlbmRlZHN0YXR1cyI6IiIsInVhX2hvdXNlTnVtX2V4dGVuZGVkc3RhdHVzIjoiIiwidWFfaG91c2VQYXJ0TnVtX2V4dGVuZGVkc3RhdHVzIjoiIiwidWFfYXBhcnRtZW50c051bV9leHRlbmRlZHN0YXR1cyI6IiIsInVhX3Bvc3RDb2RlX2V4dGVuZGVkc3RhdHVzIjoiIiwiZW5nX21pZGRsZW5hbWVfZXh0ZW5kZWRzdGF0dXMiOiIiLCJ1a3JfbWlkZGxlbmFtZV9leHRlbmRlZHN0YXR1cyI6IiIsImVuZ19wb3N0Q29kZV9leHRlbmRlZHN0YXR1cyI6IiIsImVuZ19mdWxsbmFtZSI6IiIsInVrcl9mdWxsbmFtZSI6IiIsInBlcmNlbnQtb3duZXJzaGlwX2V4dGVuZGVkc3RhdHVzIjoiMSJ9fSwiY29zdERhdGVfZXh0ZW5kZWRzdGF0dXMiOiIyIiwiY29zdEFzc2Vzc21lbnRfZXh0ZW5kZWRzdGF0dXMiOiIxIiwidWFfc3RyZWV0X2V4dGVuZGVkc3RhdHVzIjoiMSIsInVhX2hvdXNlTnVtX2V4dGVuZGVkc3RhdHVzIjoiMSIsInVhX2hvdXNlUGFydE51bV9leHRlbmRlZHN0YXR1cyI6IjEiLCJ1YV9hcGFydG1lbnRzTnVtX2V4dGVuZGVkc3RhdHVzIjoiMSJ9LCIxNDc3MDcxNzkzMDk2Ijp7InBlcnNvbiI6IjE0NzcwNzEzMDcyOTMiLCJvYmplY3RUeXBlIjoi0JrQstCw0YDRgtC40YDQsCIsIm90aGVyT2JqZWN0VHlwZSI6IiIsInRvdGFsQXJlYSI6Ijc0Iiwib3duaW5nRGF0ZSI6IjE1LjExLjIwMTIiLCJjb3N0RGF0ZSI6IjQ5MzI5NiIsImNvc3RBc3Nlc3NtZW50IjoiIiwiY291bnRyeSI6IjEiLCJ1YV9wb3N0Q29kZSI6IjY1MDI5IiwicmVnaW9uIjoiMS4yLjUxIiwiZGlzdHJpY3QiOiIxLjIuNTEuMS4xIiwiY2l0eSI6IiIsInVhX2NpdHlUeXBlIjoi0J7QtNC10YHQsCAvINCe0LTQtdGB0YzQutCwINCe0LHQu9Cw0YHRgtGMIC8g0KPQutGA0LDRl9C90LAiLCJjaXR5UGF0aCI6IjEuMi41MS4xLjEiLCJ1YV9zdHJlZXRUeXBlIjoi0LLRg9C70LjRhtGPIiwidWFfc3RyZWV0Ijoi0JPRgNCw0LTQvtC90LDRh9Cw0LvRjNC90LjRhtGM0LrQsCIsInBvc3RDb2RlIjoiIiwicmlnaHRzIjp7IjE0NzcwNzEzMDcyOTMiOnsib3duZXJzaGlwVHlwZSI6ItCS0LvQsNGB0L3RltGB0YLRjCIsIm90aGVyT3duZXJzaGlwIjoiIiwicGVyY2VudC1vd25lcnNoaXAiOiIiLCJyaWdodEJlbG9uZ3MiOiIxNDc3MDcxMzA3MjkzIiwiY2l0aXplbiI6IiIsInVhX2NpdHkiOiIiLCJyaWdodHNfY2l0eVBhdGgiOiIiLCJ1YV9sYXN0bmFtZSI6IiIsInVhX2ZpcnN0bmFtZSI6IiIsInVhX21pZGRsZW5hbWUiOiIiLCJ1YV9zdHJlZXRUeXBlIjoiIiwidWFfc3RyZWV0IjoiIiwidWFfcG9zdENvZGUiOiIiLCJ1YV9jb21wYW55X25hbWUiOiIiLCJlbmdfbGFzdG5hbWUiOiIiLCJlbmdfZmlyc3RuYW1lIjoiIiwiZW5nX21pZGRsZW5hbWUiOiIiLCJ1a3JfbGFzdG5hbWUiOiIiLCJ1a3JfZmlyc3RuYW1lIjoiIiwidWtyX21pZGRsZW5hbWUiOiIiLCJlbmdfcG9zdENvZGUiOiIiLCJlbmdfY29tcGFueV9uYW1lIjoiIiwidWtyX2NvbXBhbnlfbmFtZSI6IiIsInVhX21pZGRsZW5hbWVfZXh0ZW5kZWRzdGF0dXMiOiIiLCJ1YV9zdHJlZXRfZXh0ZW5kZWRzdGF0dXMiOiIiLCJ1YV9ob3VzZU51bV9leHRlbmRlZHN0YXR1cyI6IiIsInVhX2hvdXNlUGFydE51bV9leHRlbmRlZHN0YXR1cyI6IiIsInVhX2FwYXJ0bWVudHNOdW1fZXh0ZW5kZWRzdGF0dXMiOiIiLCJ1YV9wb3N0Q29kZV9leHRlbmRlZHN0YXR1cyI6IiIsImVuZ19taWRkbGVuYW1lX2V4dGVuZGVkc3RhdHVzIjoiIiwidWtyX21pZGRsZW5hbWVfZXh0ZW5kZWRzdGF0dXMiOiIiLCJlbmdfcG9zdENvZGVfZXh0ZW5kZWRzdGF0dXMiOiIiLCJlbmdfZnVsbG5hbWUiOiIiLCJ1a3JfZnVsbG5hbWUiOiIiLCJwZXJjZW50LW93bmVyc2hpcF9leHRlbmRlZHN0YXR1cyI6IjEifX0sImNvc3RBc3Nlc3NtZW50X2V4dGVuZGVkc3RhdHVzIjoiMiJ9fX0sIjQiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjUiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjYiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjciOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjgiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjkiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjEwIjp7ImlzTm90QXBwbGljYWJsZSI6MSwiZGF0YSI6e319LCIxMSI6eyJpc05vdEFwcGxpY2FibGUiOjAsImRhdGEiOnsiMTQ3NjYwMDIzMDc2OSI6eyJwZXJzb24iOiIxIiwib2JqZWN0VHlwZSI6ItCX0LDRgNC+0LHRltGC0L3QsCDQv9C70LDRgtCwINC+0YLRgNC40LzQsNC90LAg0LfQsCDQvtGB0L3QvtCy0L3QuNC8INC80ZbRgdGG0LXQvCDRgNC+0LHQvtGC0LgiLCJvdGhlck9iamVjdFR5cGUiOiIiLCJzaXplSW5jb21lIjoiNDA5MDUiLCJpbmNvbWVTb3VyY2UiOiJqIiwic291cmNlX2NpdGl6ZW4iOiLQrtGA0LjQtNC40YfQvdCwINC+0YHQvtCx0LAsINC30LDRgNC10ZTRgdGC0YDQvtCy0LDQvdCwINCyINCj0LrRgNCw0ZfQvdGWIiwic291cmNlX3VhX2xhc3RuYW1lIjoiIiwic291cmNlX3VhX2ZpcnN0bmFtZSI6IiIsInNvdXJjZV91YV9taWRkbGVuYW1lIjoiIiwic291cmNlX3VhX3NhbWVSZWdMaXZpbmdBZGRyZXNzIjoiIiwic291cmNlX3VhX2NvbXBhbnlfbmFtZSI6ItCX0LDQutCw0YDQv9Cw0YLRgdGM0LrQsCDQvNC40YLQvdC40YbRjyDQlNCk0KEiLCJzb3VyY2VfZW5nX2Z1bGxuYW1lIjoiIiwic291cmNlX3Vrcl9mdWxsbmFtZSI6IiIsInNvdXJjZV9lbmdfY29tcGFueV9uYW1lIjoiIiwic291cmNlX3Vrcl9jb21wYW55X25hbWUiOiIiLCJyaWdodHMiOnsiMSI6eyJvd25lcnNoaXBUeXBlIjoi0JLQu9Cw0YHQvdGW0YHRgtGMIiwib3RoZXJPd25lcnNoaXAiOiIiLCJwZXJjZW50LW93bmVyc2hpcCI6IiIsInJpZ2h0QmVsb25ncyI6IjEiLCJjaXRpemVuIjoiIiwidWFfY2l0eSI6IiIsInJpZ2h0c19jaXR5UGF0aCI6IiIsInVhX2xhc3RuYW1lIjoiIiwidWFfZmlyc3RuYW1lIjoiIiwidWFfbWlkZGxlbmFtZSI6IiIsInVhX3N0cmVldFR5cGUiOiIiLCJ1YV9zdHJlZXQiOiIiLCJ1YV9wb3N0Q29kZSI6IiIsInVhX2NvbXBhbnlfbmFtZSI6IiIsImVuZ19sYXN0bmFtZSI6IiIsImVuZ19maXJzdG5hbWUiOiIiLCJlbmdfbWlkZGxlbmFtZSI6IiIsInVrcl9sYXN0bmFtZSI6IiIsInVrcl9maXJzdG5hbWUiOiIiLCJ1a3JfbWlkZGxlbmFtZSI6IiIsImVuZ19wb3N0Q29kZSI6IiIsImVuZ19jb21wYW55X25hbWUiOiIiLCJ1a3JfY29tcGFueV9uYW1lIjoiIiwidWFfbWlkZGxlbmFtZV9leHRlbmRlZHN0YXR1cyI6IiIsInVhX3N0cmVldF9leHRlbmRlZHN0YXR1cyI6IiIsInVhX2hvdXNlTnVtX2V4dGVuZGVkc3RhdHVzIjoiIiwidWFfaG91c2VQYXJ0TnVtX2V4dGVuZGVkc3RhdHVzIjoiIiwidWFfYXBhcnRtZW50c051bV9leHRlbmRlZHN0YXR1cyI6IiIsInVhX3Bvc3RDb2RlX2V4dGVuZGVkc3RhdHVzIjoiIiwiZW5nX21pZGRsZW5hbWVfZXh0ZW5kZWRzdGF0dXMiOiIiLCJ1a3JfbWlkZGxlbmFtZV9leHRlbmRlZHN0YXR1cyI6IiIsImVuZ19wb3N0Q29kZV9leHRlbmRlZHN0YXR1cyI6IiIsImVuZ19mdWxsbmFtZSI6IiIsInVrcl9mdWxsbmFtZSI6IiJ9fX19fSwiMTIiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjEzIjp7ImlzTm90QXBwbGljYWJsZSI6MSwiZGF0YSI6e319LCIxNCI6eyJpc05vdEFwcGxpY2FibGUiOjEsImRhdGEiOnt9fSwiMTUiOnsiaXNOb3RBcHBsaWNhYmxlIjoxLCJkYXRhIjp7fX0sIjE2Ijp7ImlzTm90QXBwbGljYWJsZSI6MSwiZGF0YSI6e319faCCCBMwgggPMIIHt6ADAgECAhQztst79yG5zgQAAACdzB8A8nJIADANBgsqhiQCAQEBAQMBATCCAVAxVDBSBgNVBAoMS9CG0L3RhNC+0YDQvNCw0YbRltC50L3Qvi3QtNC+0LLRltC00LrQvtCy0LjQuSDQtNC10L\/QsNGA0YLQsNC80LXQvdGCINCU0KTQoTFeMFwGA1UECwxV0KPQv9GA0LDQstC70ZbQvdC90Y8gKNGG0LXQvdGC0YApINGB0LXRgNGC0LjRhNGW0LrQsNGG0ZbRlyDQutC70Y7Rh9GW0LIg0IbQlNCUINCU0KTQoTFiMGAGA1UEAwxZ0JDQutGA0LXQtNC40YLQvtCy0LDQvdC40Lkg0YbQtdC90YLRgCDRgdC10YDRgtC40YTRltC60LDRhtGW0Zcg0LrQu9GO0YfRltCyINCG0JTQlCDQlNCk0KExFDASBgNVBAUMC1VBLTM5Mzg0NDc2MQswCQYDVQQGEwJVQTERMA8GA1UEBwwI0JrQuNGX0LIwHhcNMTYwOTI1MjEwMDAwWhcNMTgwOTI1MjEwMDAwWjCCAXcxNzA1BgNVBAoMLtCX0JDQmtCQ0KDQn9CQ0KLQodCs0JrQkCDQnNCY0KLQndCY0KbQryDQlNCk0KExNzA1BgNVBAsMLtCc0LjRgtC90LjQuSDQv9C+0YHRgiAi0JfQsNC70ZbQt9C90LjRh9C90LjQuSIxNTAzBgNVBAwMLNC90LDRh9Cw0LvRjNC90LjQuiDQvNC40YLQvdC+0LPQviDQv9C+0YHRgtGDMSQwIgYDVQQDDBvQndC10LPRltC90YHRjNC60LjQuSDQhi7Qki4xHTAbBgNVBAQMFNCd0LXQs9GW0L3RgdGM0LrQuNC5MSwwKgYDVQQqDCPQhtCz0L7RgCDQktC+0LvQvtC00LjQvNC40YDQvtCy0LjRhzEQMA4GA1UEBQwHMjA4Mzk5NzELMAkGA1UEBhMCVUExFzAVBgNVBAcMDtCj0LbQs9C+0YDQvtC0MSEwHwYDVQQIDBjQl9Cw0LrQsNGA0L\/QsNGC0YHRjNC60LAwgfIwgckGCyqGJAIBAQEBAwEBMIG5MHUwBwICAQECAQwCAQAEIRC+49tq6p4fhleMRcEllP+UI5Sn1zj5GH5lFQFylPTOAQIhAIAAAAAAAAAAAAAAAAAAAABnWSE68YLph9PhdxSQfUcNBCG2D9LY3OipNCPGEBvKkcR6AH5sMAsmzVVsmw59IO8pKgAEQKnW60XxPHCCgMSWeyMfXq32WOukwDcpHTjZa\/Alyk4X+OlyDcYVtDool18Lwd6jZDi1ZOosF5\/QEj5tuPrFeQQDJAAEIfSqw5UzWL0CW68ny\/wTqNa5CG8sV7652xAU8qSj8GvDAKOCA6UwggOhMCkGA1UdDgQiBCBH64drxk7pYqhtvdCpe5alp32WygY5P9OREA5FqkiXADArBgNVHSMEJDAigCAztst79yG5zu7j3i5i\/uo7cBpLZ2C8HC\/PNWUWtQ68qjAvBgNVHRAEKDAmoBEYDzIwMTYwOTI1MjEwMDAwWqERGA8yMDE4MDkyNTIxMDAwMFowDgYDVR0PAQH\/BAQDAgbAMBkGA1UdIAEB\/wQPMA0wCwYJKoYkAgEBAQICMAwGA1UdEwEB\/wQCMAAwNwYIKwYBBQUHAQMBAf8EKDAmMAsGCSqGJAIBAQECATAXBgYEAI5GAQIwDRMDVUFIAgMPQkACAQAwgf0GA1UdEQSB9TCB8qCBkgYMKwYBBAGBl0YBAQQCoIGBDH84ODAwMCwg0JfQsNC60LDRgNC\/0LDRgtGB0YzQutCwINC+0LHQuy4sINCj0LbQs9C+0YDQvtC00YHRjNC60LjQuSDRgC3QvSwg0LwuINCj0LbQs9C+0YDQvtC0LCDQstGD0LsuINCh0L7QsdGA0LDQvdC10YbRjNC60LAsIDIwoC4GDCsGAQQBgZdGAQEEAaAeDBwoMDMxKSAyNjQ5NjAwLCAoMDMxKSAyNjEyMjA3gRZ6YWtAY3VzdG9tcy5zZnMuZ292LnVhoBMGCisGAQQBgjcUAgOgBQwDMTIxMEgGA1UdHwRBMD8wPaA7oDmGN2h0dHA6Ly9hY3NraWRkLmdvdi51YS9kb3dubG9hZC9jcmxzL0FDU0tJRERERlMtRnVsbC5jcmwwSQYDVR0uBEIwQDA+oDygOoY4aHR0cDovL2Fjc2tpZGQuZ292LnVhL2Rvd25sb2FkL2NybHMvQUNTS0lERERGUy1EZWx0YS5jcmwwgYgGCCsGAQUFBwEBBHwwejAwBggrBgEFBQcwAYYkaHR0cDovL2Fjc2tpZGQuZ292LnVhL3NlcnZpY2VzL29jc3AvMEYGCCsGAQUFBzAChjpodHRwOi8vYWNza2lkZC5nb3YudWEvZG93bmxvYWQvY2VydGlmaWNhdGVzL2FsbGFjc2tpZGQucDdiMD8GCCsGAQUFBwELBDMwMTAvBggrBgEFBQcwA4YjaHR0cDovL2Fjc2tpZGQuZ292LnVhL3NlcnZpY2VzL3RzcC8wQwYDVR0JBDwwOjAaBgwqhiQCAQEBCwEEAgExChMIMzk1MTU4OTMwHAYMKoYkAgEBAQsBBAEBMQwTCjIyNTU1MTUxMzMwDQYLKoYkAgEBAQEDAQEDQwAEQDEAGkuTHY6K1uqLQlBtjAjzlTHbK14VCX9L6TLBfhJ5ufK827YsK73yE7GhqXSsobGvA6zdbaCCNInkbwMdWR4xgggTMIIIDwIBATCCAWowggFQMVQwUgYDVQQKDEvQhtC90YTQvtGA0LzQsNGG0ZbQudC90L4t0LTQvtCy0ZbQtNC60L7QstC40Lkg0LTQtdC\/0LDRgNGC0LDQvNC10L3RgiDQlNCk0KExXjBcBgNVBAsMVdCj0L\/RgNCw0LLQu9GW0L3QvdGPICjRhtC10L3RgtGAKSDRgdC10YDRgtC40YTRltC60LDRhtGW0Zcg0LrQu9GO0YfRltCyINCG0JTQlCDQlNCk0KExYjBgBgNVBAMMWdCQ0LrRgNC10LTQuNGC0L7QstCw0L3QuNC5INGG0LXQvdGC0YAg0YHQtdGA0YLQuNGE0ZbQutCw0YbRltGXINC60LvRjtGH0ZbQsiDQhtCU0JQg0JTQpNChMRQwEgYDVQQFDAtVQS0zOTM4NDQ3NjELMAkGA1UEBhMCVUExETAPBgNVBAcMCNCa0LjRl9CyAhQztst79yG5zgQAAACdzB8A8nJIADAMBgoqhiQCAQEBAQIBoIIGOzAYBgkqhkiG9w0BCQMxCwYJKoZIhvcNAQcBMBwGCSqGSIb3DQEJBTEPFw0xNjEwMjExODExMzBaMC8GCSqGSIb3DQEJBDEiBCDWczj09FFd6z+BdsqpCc8IvOxJIgyKbvjXpHfnv+F0nTCCAcMGCyqGSIb3DQEJEAIvMYIBsjCCAa4wggGqMIIBpjAMBgoqhiQCAQEBAQIBBCCMEEslkg5qD5\/39BZ8LrotvwRA4o5UMCOTLV7T7wvkPTCCAXIwggFYpIIBVDCCAVAxVDBSBgNVBAoMS9CG0L3RhNC+0YDQvNCw0YbRltC50L3Qvi3QtNC+0LLRltC00LrQvtCy0LjQuSDQtNC10L\/QsNGA0YLQsNC80LXQvdGCINCU0KTQoTFeMFwGA1UECwxV0KPQv9GA0LDQstC70ZbQvdC90Y8gKNGG0LXQvdGC0YApINGB0LXRgNGC0LjRhNGW0LrQsNGG0ZbRlyDQutC70Y7Rh9GW0LIg0IbQlNCUINCU0KTQoTFiMGAGA1UEAwxZ0JDQutGA0LXQtNC40YLQvtCy0LDQvdC40Lkg0YbQtdC90YLRgCDRgdC10YDRgtC40YTRltC60LDRhtGW0Zcg0LrQu9GO0YfRltCyINCG0JTQlCDQlNCk0KExFDASBgNVBAUMC1VBLTM5Mzg0NDc2MQswCQYDVQQGEwJVQTERMA8GA1UEBwwI0JrQuNGX0LICFDO2y3v3IbnOBAAAAJ3MHwDyckgAMIIEBwYLKoZIhvcNAQkQAhQxggP2MIID8gYJKoZIhvcNAQcCoIID4zCCA98CAQMxDjAMBgoqhiQCAQEBAQIBMGsGCyqGSIb3DQEJEAEEoFwEWjBYAgEBBgoqhiQCAQEBAgMBMDAwDAYKKoYkAgEBAQECAQQg1nM49PRRXes\/gXbKqQnPCLzsSSIMim7416R357\/hdJ0CBAD9rBgYDzIwMTYxMDIxMTgxMTI2WjGCA1swggNXAgEBMIIBEzCB+jE\/MD0GA1UECgw20JzRltC90ZbRgdGC0LXRgNGB0YLQstC+INGO0YHRgtC40YbRltGXINCj0LrRgNCw0ZfQvdC4MTEwLwYDVQQLDCjQkNC00LzRltC90ZbRgdGC0YDQsNGC0L7RgCDQhtCi0KEg0KbQl9CeMUkwRwYDVQQDDEDQptC10L3RgtGA0LDQu9GM0L3QuNC5INC30LDRgdCy0ZbQtNGH0YPQstCw0LvRjNC90LjQuSDQvtGA0LPQsNC9MRkwFwYDVQQFDBBVQS0wMDAxNTYyMi0yMDEyMQswCQYDVQQGEwJVQTERMA8GA1UEBwwI0JrQuNGX0LICFDAEdR3vLHiuAgAAAAEAAABOAAAAMAwGCiqGJAIBAQEBAgGgggHaMBoGCSqGSIb3DQEJAzENBgsqhkiG9w0BCRABBDAcBgkqhkiG9w0BCQUxDxcNMTYxMDIxMTgxMTI2WjAvBgkqhkiG9w0BCQQxIgQgVsWVPXeDrR8bdQ0Ws5miU\/i2BR2k2hL7eOBHNBwPsUAwggFrBgsqhkiG9w0BCRACLzGCAVowggFWMIIBUjCCAU4wDAYKKoYkAgEBAQECAQQglxEgC4hcQDrqQ8Chu0VXMcgdi06ummj6vtKcoz+h1gEwggEaMIIBAKSB\/TCB+jE\/MD0GA1UECgw20JzRltC90ZbRgdGC0LXRgNGB0YLQstC+INGO0YHRgtC40YbRltGXINCj0LrRgNCw0ZfQvdC4MTEwLwYDVQQLDCjQkNC00LzRltC90ZbRgdGC0YDQsNGC0L7RgCDQhtCi0KEg0KbQl9CeMUkwRwYDVQQDDEDQptC10L3RgtGA0LDQu9GM0L3QuNC5INC30LDRgdCy0ZbQtNGH0YPQstCw0LvRjNC90LjQuSDQvtGA0LPQsNC9MRkwFwYDVQQFDBBVQS0wMDAxNTYyMi0yMDEyMQswCQYDVQQGEwJVQTERMA8GA1UEBwwI0JrQuNGX0LICFDAEdR3vLHiuAgAAAAEAAABOAAAAMA0GCyqGJAIBAQEBAwEBBECMIbU0RQ96HNEuQzZzUEa3o+9bAroGRFIgIrgJeC\/VaznzwzOuzhnXcP6odKmiHg2rqxfLHhY86sEFNvgJ3EB\/MA0GCyqGJAIBAQEBAwEBBEBdDm5eQVTGBjmYSECkoF6I1zEOpo40ybdMwkKTdxVFWBfPDv0lq7VvKv+jXZM9uqwCRlf6Iky31qU+umnDFg1O",
  "data": {
    "step_0": {
      "declarationType": "1",
      "declarationYear1": "2015"
    },
    "step_1": {
      "region": "1.2.51",
      "street": "Люстдорфська дорога",
      "country": "1",
      "cityPath": "1.2.51.1.1",
      "cityType": "Одеса \/ Одеська Область \/ Україна",
      "district": "1.2.51.1.1",
      "lastname": "Негінський",
      "postCode": "65113",
      "postType": "Посада державної служби",
      "workPost": "Начальник митного посту",
      "firstname": "Ігор",
      "workPlace": "Закарпатська митниця ДФС",
      "middlename": "Володимирович",
      "streetType": "вулиця",
      "changedName": false,
      "countryPath": "",
      "eng_postCode": "",
      "postCategory": "Б",
      "actual_region": "1.2.21",
      "actual_street": "Миру",
      "actual_country": "1",
      "actual_cityPath": "1.2.21.1.10",
      "actual_cityType": "Чоп \/ Закарпатська Область \/ Україна",
      "actual_district": "1.2.21.1.10",
      "actual_postCode": "89502",
      "actual_streetType": "вулиця",
      "previous_lastname": "",
      "corruptionAffected": "Ні",
      "eng_actualPostCode": "",
      "previous_firstname": "",
      "previous_middlename": "",
      "responsiblePosition": "Державний службовець, посада якого належить до посад державної служби категорії 'А' або 'Б'",
      "sameRegLivingAddress": false,
      "eng_sameRegLivingAddress": "",
      "actual_housePartNum_extendedstatus": "1"
    },
    "step_2": {
      "1477071307293": {
        "lastname": "Негінська",
        "firstname": "Карина",
        "middlename": "Ігорівна",
        "changedName": false,
        "citizenship": "1",
        "eng_lastname": "",
        "no_taxNumber": false,
        "eng_firstname": "",
        "eng_middlename": "",
        "isNotApplicable": "",
        "subjectRelation": "дочка",
        "previous_lastname": "",
        "previous_firstname": "",
        "previous_middlename": "",
        "previous_eng_lastname": "",
        "previous_eng_firstname": "",
        "previous_eng_middlename": ""
      }
    },
    "step_3": {
      "1476517569458": {
        "city": "1.2.51.2.39.8.17.1.4",
        "person": "1",
        "region": "1.2.51",
        "rights": {
          "1": {
            "citizen": "",
            "ua_city": "",
            "ua_street": "[Конфіденційна інформація]",
            "ua_lastname": "",
            "ua_postCode": "",
            "eng_fullname": "",
            "eng_lastname": "",
            "eng_postCode": "",
            "rightBelongs": "1",
            "ua_firstname": "",
            "ukr_fullname": "",
            "ukr_lastname": "",
            "eng_firstname": "",
            "ownershipType": "Власність",
            "ua_middlename": "",
            "ua_streetType": "[Конфіденційна інформація]",
            "ukr_firstname": "",
            "eng_middlename": "",
            "otherOwnership": "",
            "ukr_middlename": "",
            "rights_cityPath": "",
            "ua_company_name": "",
            "eng_company_name": "",
            "ukr_company_name": "",
            "percent-ownership": "",
            "ua_street_extendedstatus": "",
            "ua_houseNum_extendedstatus": "",
            "ua_postCode_extendedstatus": "",
            "eng_postCode_extendedstatus": "",
            "ua_middlename_extendedstatus": "",
            "eng_middlename_extendedstatus": "",
            "ukr_middlename_extendedstatus": "",
            "ua_housePartNum_extendedstatus": "",
            "ua_apartmentsNum_extendedstatus": "",
            "percent-ownership_extendedstatus": "1"
          }
        },
        "country": "1",
        "cityPath": "1.2.51.2.39.8.17.1.4",
        "costDate": "",
        "district": "1.2.51.2.39",
        "postCode": "",
        "totalArea": "559",
        "ua_street": "[Конфіденційна інформація]",
        "objectType": "Земельна ділянка",
        "owningDate": "17.08.2009",
        "ua_cityType": "Бурдівка \/ Роздільнянський Район \/ Одеська Область \/ Україна",
        "ua_postCode": "67443",
        "ua_streetType": "[Конфіденційна інформація]",
        "costAssessment": "",
        "otherObjectType": "",
        "costDate_extendedstatus": "2",
        "ua_street_extendedstatus": "1",
        "ua_houseNum_extendedstatus": "1",
        "costAssessment_extendedstatus": "1",
        "ua_housePartNum_extendedstatus": "1",
        "ua_apartmentsNum_extendedstatus": "1"
      },
      "1477071793096": {
        "city": "",
        "person": "1477071307293",
        "region": "1.2.51",
        "rights": {
          "1477071307293": {
            "citizen": "",
            "ua_city": "",
            "ua_street": "[Конфіденційна інформація]",
            "ua_lastname": "",
            "ua_postCode": "",
            "eng_fullname": "",
            "eng_lastname": "",
            "eng_postCode": "",
            "rightBelongs": "1477071307293",
            "ua_firstname": "",
            "ukr_fullname": "",
            "ukr_lastname": "",
            "eng_firstname": "",
            "ownershipType": "Власність",
            "ua_middlename": "",
            "ua_streetType": "[Конфіденційна інформація]",
            "ukr_firstname": "",
            "eng_middlename": "",
            "otherOwnership": "",
            "ukr_middlename": "",
            "rights_cityPath": "",
            "ua_company_name": "",
            "eng_company_name": "",
            "ukr_company_name": "",
            "percent-ownership": "",
            "ua_street_extendedstatus": "",
            "ua_houseNum_extendedstatus": "",
            "ua_postCode_extendedstatus": "",
            "eng_postCode_extendedstatus": "",
            "ua_middlename_extendedstatus": "",
            "eng_middlename_extendedstatus": "",
            "ukr_middlename_extendedstatus": "",
            "ua_housePartNum_extendedstatus": "",
            "ua_apartmentsNum_extendedstatus": "",
            "percent-ownership_extendedstatus": "1"
          }
        },
        "country": "1",
        "cityPath": "1.2.51.1.1",
        "costDate": "493296",
        "district": "1.2.51.1.1",
        "postCode": "",
        "totalArea": "74",
        "ua_street": "[Конфіденційна інформація]",
        "objectType": "Квартира",
        "owningDate": "15.11.2012",
        "ua_cityType": "Одеса \/ Одеська Область \/ Україна",
        "ua_postCode": "65029",
        "ua_streetType": "[Конфіденційна інформація]",
        "costAssessment": "",
        "otherObjectType": "",
        "costAssessment_extendedstatus": "2"
      }
    },
    "step_4": [

    ],
    "step_5": [

    ],
    "step_6": [

    ],
    "step_7": [

    ],
    "step_8": [

    ],
    "step_9": [

    ],
    "step_10": [

    ],
    "step_11": {
      "1476600230769": {
        "person": "1",
        "rights": {
          "1": {
            "citizen": "",
            "ua_city": "",
            "ua_street": "[Конфіденційна інформація]",
            "ua_lastname": "",
            "ua_postCode": "",
            "eng_fullname": "",
            "eng_lastname": "",
            "eng_postCode": "",
            "rightBelongs": "1",
            "ua_firstname": "",
            "ukr_fullname": "",
            "ukr_lastname": "",
            "eng_firstname": "",
            "ownershipType": "Власність",
            "ua_middlename": "",
            "ua_streetType": "[Конфіденційна інформація]",
            "ukr_firstname": "",
            "eng_middlename": "",
            "otherOwnership": "",
            "ukr_middlename": "",
            "rights_cityPath": "",
            "ua_company_name": "",
            "eng_company_name": "",
            "ukr_company_name": "",
            "percent-ownership": "",
            "ua_street_extendedstatus": "",
            "ua_houseNum_extendedstatus": "",
            "ua_postCode_extendedstatus": "",
            "eng_postCode_extendedstatus": "",
            "ua_middlename_extendedstatus": "",
            "eng_middlename_extendedstatus": "",
            "ukr_middlename_extendedstatus": "",
            "ua_housePartNum_extendedstatus": "",
            "ua_apartmentsNum_extendedstatus": ""
          }
        },
        "objectType": "Заробітна плата отримана за основним місцем роботи",
        "sizeIncome": "40905",
        "incomeSource": "j",
        "source_citizen": "Юридична особа, зареєстрована в Україні",
        "otherObjectType": "",
        "source_ua_lastname": "",
        "source_eng_fullname": "",
        "source_ua_firstname": "",
        "source_ukr_fullname": "",
        "source_ua_middlename": "",
        "source_ua_company_name": "Закарпатська митниця ДФС",
        "source_eng_company_name": "",
        "source_ukr_company_name": "",
        "source_ua_sameRegLivingAddress": ""
      }
    },
    "step_12": [

    ],
    "step_13": [

    ],
    "step_14": [

    ],
    "step_15": [

    ],
    "step_16": [

    ]
  }
}
```
