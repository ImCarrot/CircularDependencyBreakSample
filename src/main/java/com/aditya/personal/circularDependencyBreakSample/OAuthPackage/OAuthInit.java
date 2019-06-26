package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

public interface OAuthInit {

    static TokenFetcher getOAuth(FireAPI fireAPI){
        return new TokenFetcherImpl(fireAPI);
    }

}
