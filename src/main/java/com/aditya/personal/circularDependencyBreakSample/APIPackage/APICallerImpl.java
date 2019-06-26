package com.aditya.personal.circularDependencyBreakSample.APIPackage;

class APICallerImpl implements APICaller {

    private final OAuthProvider provider;

    APICallerImpl(OAuthProvider provider){
        this.provider = provider;
    }

    public String callAPI(boolean supportOAuth, String... params) {


        if (!supportOAuth)
            return String.join("~", params);

        if (provider == null)
            throw new IllegalArgumentException("Provider not found bitch!");

        String token = provider.getToken();

        return String.format("%s!!!%s", token, String.join("~", params));
    }

}
