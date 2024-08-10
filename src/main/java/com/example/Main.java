package com.example;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

public class Main {

    public static void main(String[] args) throws Throwable {
        try (final var arena = Arena.ofConfined()) {

            final var linker = Linker.nativeLinker();

            final var symbolLookup = linker.defaultLookup();

            final var memorySegment = symbolLookup.find("strlen").orElseThrow();

            final var functionDescriptor =
                    FunctionDescriptor.of(JAVA_LONG, ADDRESS);

            final var methodHandle = linker.downcallHandle(memorySegment, functionDescriptor);

            final var segmentAllocator = arena.allocateFrom("Hello world");

            final var result = (long) methodHandle.invokeExact(segmentAllocator);

            System.out.println(result);
        }

    }

}
