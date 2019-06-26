package com.aditya.personal.circularDependencyBreakSample.APIPackage;

public interface APIInit {

    static APICaller initCaller(OAuthProvider provider) {
        return new APICallerImpl(provider);

    }

}
