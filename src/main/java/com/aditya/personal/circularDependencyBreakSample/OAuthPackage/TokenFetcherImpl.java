package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

class TokenFetcherImpl implements TokenFetcher {

    private final FireAPI apiFirer;

    private final String CI;
    private final String CS;

    TokenFetcherImpl(String CI, String CS, FireAPI apiFirer) {
        this.apiFirer = apiFirer;
        this.CI = CI;
        this.CS = CS;
    }

    @Override
    public String fetchToken() {

        if (CI == null || CS ==null)
            throw new IllegalArgumentException("Missing CI/CS");

        if (apiFirer == null)
            throw new IllegalArgumentException("Can't call API");

        return apiFirer.fire(String.format("%s.%s", CI, CS));
    }
}
