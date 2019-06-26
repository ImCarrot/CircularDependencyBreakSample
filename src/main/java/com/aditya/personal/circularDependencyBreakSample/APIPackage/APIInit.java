package com.aditya.personal.circularDependencyBreakSample.APIPackage;

import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.OAuthInit;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.TokenFetcher;

public interface APIInit {

    static APICaller initCaller(String CI, String CS){

        TokenFetcher provider = OAuthInit.getOAuth(new APICallerImpl());
        provider.init(CI, CS);
        return new APICallerImpl(provider);
    }

}
