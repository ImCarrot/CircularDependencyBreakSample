package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

class TokenFetcherImpl implements TokenFetcher {

    private final FireAPI apiFirer;

    TokenFetcherImpl(FireAPI apiFirer) {
        this.apiFirer = apiFirer;
    }

    @Override
    public String fetchToken(String CI, String CS) {

        if (CI == null || CS ==null)
            throw new IllegalArgumentException("Missing CI/CS");

        if (apiFirer == null)
            throw new IllegalArgumentException("Can't call API");

        return apiFirer.fire(String.format("|%s_%s|", CI, CS));
    }
}
