package com.biography.profile.factory;

public interface Factory<T> {

    T createDefault();

    T createEmpty();
}
