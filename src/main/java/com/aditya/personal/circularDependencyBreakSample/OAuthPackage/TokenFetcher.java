package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

public interface TokenFetcher {

    void init(final String CI, final String CS);

    String fetchToken();

}
