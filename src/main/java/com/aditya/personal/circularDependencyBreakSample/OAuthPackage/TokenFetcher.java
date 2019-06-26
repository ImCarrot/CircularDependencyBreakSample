package com.aditya.personal.circularDependencyBreakSample.OAuthPackage;

public interface TokenFetcher {

    String fetchToken(final String CI, final String CS);

}
