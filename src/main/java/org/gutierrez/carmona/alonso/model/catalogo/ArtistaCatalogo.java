package org.gutierrez.carmona.alonso.model.catalogo;

import org.gutierrez.carmona.alonso.Jdbc.ArtistaJdbc;
import org.gutierrez.carmona.alonso.Jdbc.ArtistaJdbcImpl;
import org.gutierrez.carmona.alonso.consola.Catalogos;
import org.gutierrez.carmona.alonso.model.normal.Artista;
import org.gutierrez.carmona.alonso.util.ReadUtil;

import java.util.List;

public class ArtistaCatalogo extends Catalogos<Artista>
{
    private static ArtistaCatalogo artistaCatalogo;
    private static ArtistaJdbc artistaJdbc;

    private ArtistaCatalogo( )
    {
        super();
    }

    public static ArtistaCatalogo getInstance( )
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT() {
        return new Artista( );
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Teclee un artista" );
        artista.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("Id del Artista " + artista.getId( ) );
        System.out.println("Artista a editar: " + artista.getNombre( ) );
        System.out.println("Teclee el valor nuevo del artista" );
        artista.setNombre( ReadUtil.read( ) );
    }

    @Override
    public List<Artista> processList() {
        System.out.println(artistaJdbc);
        if( artistaJdbc == null )
        {
            if( !loadArtistajdbc( ) )
            {
                System.out.println("Error al cargar el artistajdbc");
                return null;
            }
        }
        return artistaJdbc.findAll( );
    }

    private boolean loadArtistajdbc()
    {
        artistaJdbc = ArtistaJdbcImpl.getInstance( );
        return artistaJdbc != null;
    }
}
