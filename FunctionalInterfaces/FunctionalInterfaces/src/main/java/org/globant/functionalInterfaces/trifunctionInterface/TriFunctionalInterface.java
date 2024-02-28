package org.globant.functionalInterfaces.trifunctionInterface;

/**
 * Multipurpose functional interface.
 *
 * @param <X> Generic data type.
 * @param <Y> Generic data type.
 * @param <Z> Generic data type.
 * @param <W> Generic data type.
 */
@FunctionalInterface
public interface TriFunctionalInterface<X, Y, Z, W> {
    /**
     * Apply w.
     *
     * @param x generic data type
     * @param y generic data type
     * @param z generic data type
     * @return w generic data type
     */
    W apply(X x, Y y, Z z);
}
