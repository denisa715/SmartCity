public abstract class ElementUrban {
    protected int id;
    public ElementUrban(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public abstract String descriere();
}
