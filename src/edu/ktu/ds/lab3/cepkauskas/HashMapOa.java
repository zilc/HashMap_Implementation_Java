package edu.ktu.ds.lab3.cepkauskas;


public class HashMapOa<V, K> implements Map<K,V> {

    private int size;
    private V v;

    /**
     * Patikrinama ar atvaizdis yra tuščias.
     *
     * @return true, jei tuščias
     */
    @Override
    public boolean isEmpty(){
        return size == 0;
    }



    /**
     * Grąžinamas atvaizdyje esančių porų kiekis.
     *
     * @return Grąžinamas atvaizdyje esančių porų kiekis.
     */
    public int size(){
        return size;
    }

    /**
     * Išvalomas atvaizdis.
     *
     */
    public void clear(){

    }

    /**
     * Grąžinamas porų masyvas.
     *
     * @return Grąžinamas porų masyvas.
     */
    public  String[][] toArray(){
        return new String[5][5];
    }

    /**
     * Atvaizdis papildomas nauja pora.
     *
     * @param key raktas,
     * @param value reikšmė.
     * @return Grąžinama atvaizdžio poros reikšmė.
     */
    public V put(K key, V value){
        return  value;
    }

    /**
     * Grąžinama atvaizdžio poros reikšmė.
     *
     * @param key raktas.
     * @return Grąžinama atvaizdžio poros reikšmė.
     */
   public V get(K key){
        return  v;
    }

    /**
     * Iš atvaizdžio pašalinama pora.
     *
     * @param key raktas.
     * @return Grąžinama pašalinta atvaizdžio poros reikšmė.
     */
    public V remove(K key){
        return  v;
    }

    /**
     * Patikrinama ar atvaizdyje egzistuoja pora su raktu key.
     *
     * @param key raktas.
     * @return true, jei atvaizdyje egzistuoja pora su raktu key, kitu atveju -
     * false
     */
    public boolean contains(K key){
        return true;
    }

    protected class Entry<K,V>{

        protected K key;
        protected V value;

        protected Entry(){


        }

        protected Entry(K key, V value){
            this.key = key;
            this.value = value;


        }

        @Override
        public String toString(){
            return key + "=" + value;
        }

        public void Test(){
            
        }


    }


}
