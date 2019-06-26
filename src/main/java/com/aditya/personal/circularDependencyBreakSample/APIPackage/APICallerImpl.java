package com.aditya.personal.circularDependencyBreakSample.APIPackage;

import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.FireAPI;
import com.aditya.personal.circularDependencyBreakSample.OAuthPackage.TokenFetcher;

class APICallerImpl implements APICaller, FireAPI {

    private final TokenFetcher provider;

    APICallerImpl(TokenFetcher provider) {
        this.provider = provider;
    }

    APICallerImpl() {
        provider = null;
    }

    public String callAPI(boolean supportOAuth, String... params) {

        if (!supportOAuth)
            return String.join("~", params);

        if (provider == null)
            throw new IllegalArgumentException("Provider not found bitch!");

        String token = provider.fetchToken();

        return String.format("%s|%s", token, String.join("~", params));
    }

    @Override
    public String fire(String param) {
        return this.callAPI(false, param);
    }
}
