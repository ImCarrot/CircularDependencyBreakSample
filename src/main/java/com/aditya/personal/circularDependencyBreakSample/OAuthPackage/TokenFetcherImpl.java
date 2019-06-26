package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

class TokenFetcherImpl implements TokenFetcher {

    private final FireAPI apiFirer;

    private String CI;
    private String CS;

    TokenFetcherImpl(FireAPI apiFirer) {
        this.apiFirer = apiFirer;
    }

    @Override
    public void init(String CI, String CS) {
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
