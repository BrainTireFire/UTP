/**
 *
 *  @author Kawęcki Maciej S20202
 *
 */

package zad1;


public interface Mapper<T, M> {
    // Uwaga: interfejs musi być sparametrtyzowany
    T map(M arg);
}  
