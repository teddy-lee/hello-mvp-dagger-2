package com.example.bradcampbell.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.bradcampbell.data.HelloDiskCache;
import com.example.bradcampbell.data.HelloService;
import com.example.bradcampbell.domain.Clock;
import com.example.bradcampbell.domain.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides @Singleton public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides public HelloDiskCache provideHelloDiskCache(SharedPreferences prefs) {
        return new HelloDiskCache(prefs);
    }

    @Provides public HelloService provideHelloService(Clock clock) {
        return new HelloService(clock);
    }

    @Provides public SchedulerProvider provideSchedulerProvider() {
        return SchedulerProvider.DEFAULT;
    }

    @Provides public Clock provideClock() {
        return Clock.REAL;
    }
}
