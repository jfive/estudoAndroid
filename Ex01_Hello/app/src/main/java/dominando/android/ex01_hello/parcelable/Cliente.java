package dominando.android.ex01_hello.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rodrigo on 26/07/2015.
 */
public class Cliente implements Parcelable {

    public int codigo;
    public String nome;

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    private Cliente(Parcel from){
        codigo = from.readInt();
        nome = from.readString();
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (codigo != cliente.codigo) return false;
        return !(nome != null ? !nome.equals(cliente.nome) : cliente.nome != null);

    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
