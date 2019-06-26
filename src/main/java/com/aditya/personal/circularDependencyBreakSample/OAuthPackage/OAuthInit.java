package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

public interface OAuthInit {

    static TokenFetcher getOAuth(final String CI, final String CS, FireAPI fireAPI){
        return new TokenFetcherImpl(CI, CS, fireAPI);
    }

}
