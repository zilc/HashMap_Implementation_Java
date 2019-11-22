package edu.ktu.ds.lab3.cepkauskas;


import edu.ktu.ds.lab3.utils.HashType;

import java.util.Arrays;

public class HashMapOa<K, V> implements Map<K,V> {

    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public static final HashType DEFAULT_HASH_TYPE = HashType.DIVISION;

    protected Entry<K,V>[] table;
    // Lentelėje esančių raktas-reikšmė porų kiekis
    protected int size = 0;
    // Apkrovimo faktorius
    protected float loadFactor;

    protected int rehashesCounter;
    // Maišos metodas
    protected HashType ht;

    public HashMapOa() {
        this(DEFAULT_HASH_TYPE);
    }

    public HashMapOa(HashType ht) {
        this(DEFAULT_INITIAL_CAPACITY, ht);
    }

    public HashMapOa(int initialCapacity, HashType ht) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, ht);
    }

    public HashMapOa(float loadFactor, HashType ht) {
        this(DEFAULT_INITIAL_CAPACITY, loadFactor, ht);
    }

    public HashMapOa(int initialCapacity, float loadFactor, HashType ht) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }

        if ((loadFactor <= 0.0) || (loadFactor > 1.0)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        this.table = new Entry[initialCapacity];
        this.loadFactor = loadFactor;
        this.ht = ht;
    }





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
        Arrays.fill(table, null);
        size = 0;
    }

    /**
     * Grąžinamas porų masyvas.
     *
     * @return Grąžinamas porų masyvas.
     */
    @Override
    public String[] toArray() {
        String[] result = new String[table.length];
        int count = 0;
        for (Entry<K,V> n : table) {
            if(n != null){
                result[count++] = n.toString();
            }

        }
        return result;
    }

    /**
     * Surandamas rakto indeksas atvaizdyje.
     * @param key raktas
     * @return indeksas
     */
    private int findPosition(K key){
        int index = hash(key, ht);
        int index0 = index;
        for (int i = 0; i < table.length; i++ ){
            if (table[index] == null || table[index].key.equals(key)){
                return index;
            }
            index = (index0 + i + 1) % table.length;
        }

        return -1;

    }

    /**
     * Maišos funkcijos skaičiavimas: pagal rakto maišos kodą apskaičiuojamas
     * atvaizdžio poros indeksas maišos lentelės masyve
     *
     * @param key
     * @param hashType
     * @return
     */
    private int hash(K key, HashType hashType) {
        int h = key.hashCode();
        switch (hashType) {
            case DIVISION:
                return Math.abs(h) % table.length;
            case MULTIPLICATION:
                double k = (Math.sqrt(5) - 1) / 2;
                return (int) (((k * Math.abs(h)) % 1) * table.length);
            case JCF7:
                h ^= (h >>> 20) ^ (h >>> 12);
                h = h ^ (h >>> 7) ^ (h >>> 4);
                return h & (table.length - 1);
            case JCF8:
                h = h ^ (h >>> 16);
                return h & (table.length - 1);
            default:
                return Math.abs(h) % table.length;
        }
    }

    /**
     * Atvaizdis papildomas nauja pora.
     *
     * @param key raktas,
     * @param value reikšmė.
     * @return Grąžinama atvaizdžio poros reikšmė.
     */
    @Override
    public V put(K key, V value){
        if(key == null || value == null){
            throw new NullPointerException();
        }
        int index = findPosition(key);
        if (index == -1){
            rehash();
            put(key, value);
            return value;
        }
        if (table[index] == null){
            table[index] = new Entry(key, value);
            size++;
            if (size > table.length * loadFactor){
                rehash();
            }
        } else {
            table[index].value = value;
        }
        return value;



    }

    /**
     * Permaišymas
     */
    private void rehash() {
        HashMapOa<K, V> newMap = new HashMapOa<>(table.length * 2, loadFactor, ht);
        for (int i = 0; i < table.length; i++) {
            newMap.put(table[i].key, table[i].value);
        }
        table = newMap.table;

        rehashesCounter++;
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
        return get(key) != null;
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




    }


}
