package zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListCreator <T> {
    private List<T> listGenerics;

    public ListCreator(List<T> listGenerics)
    {
        this.listGenerics = listGenerics;
    }

    public static <T> ListCreator<T> collectFrom(List<T> lista)
    {
        return new ListCreator<T>(lista);
    }

    public ListCreator<T> when(Function<T, Boolean> lambda1)
    {
        List<T> arrayListHelper = new ArrayList<T>();

        for (T listElement : this.listGenerics)
        {
            if (lambda1.apply(listElement)==true)
            {
                arrayListHelper.add(listElement);
            }
        }

        this.listGenerics = arrayListHelper;

        return this;
    }

    public <M> List<M> mapEvery(Function<T,M> lambda2)
    {
        List<M> arrayListHelper = new ArrayList<M>();

        for (T listElement : this.listGenerics)
        {
            arrayListHelper.add(lambda2.apply(listElement));
        }

        return arrayListHelper;
    }

}
