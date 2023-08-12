package com.sddevops.CWF_23003323;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CWFSongCollectionTest {
	private SongCollection sc;
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private final int SONG_COLLECTION_SIZE = 4;

	@BeforeEach
	void setUp() throws Exception {
		sc = new SongCollection();
		s1 = new Song("001", "good 4 u", "Olivia Rodrigo", 3.59);
		s2 = new Song("002", "Peaches", "Justin Bieber", 3.18);
		s3 = new Song("003", "MONTERO", "Lil Nas", 2.3);
		s4 = new Song("004", "bad guy", "billie eilish", 3.14);
		sc.addSong(s1);
		sc.addSong(s2);
		sc.addSong(s3);
		sc.addSong(s4);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetSongs() {
		// fail("Not yet implemented");
		List<Song> songs = sc.getSongs();
		assertEquals(SONG_COLLECTION_SIZE, songs.size());
		assertTrue(songs.contains(s1));
		assertTrue(songs.contains(s2));
		assertTrue(songs.contains(s3));
		assertTrue(songs.contains(s4));
	}

	@Test
	public void testAddSong() {
		// fail("Not yet implemented");
		List<Song> testSc = sc.getSongs();
		// Assert that Song Collection is equals to Song Collection Size : 4
		assertEquals(testSc.size(), SONG_COLLECTION_SIZE);
		// Act
		sc.addSong(s1);
		// Assert that Song Collection is equals to Song Collection Size + 1 : 5
		assertEquals(testSc.size(), SONG_COLLECTION_SIZE + 1);
	}

	@Test
	public void testSortSongsByTitle() {
		// fail("Not yet implemented");
		ArrayList<Song> sortedSongs = sc.sortSongsByTitle();
		for (int i = 1; i < sortedSongs.size(); i++) {
			String previousTitle = sortedSongs.get(i - 1).getTitle();
			String currentTitle = sortedSongs.get(i).getTitle();
			assertTrue(previousTitle.compareTo(currentTitle) <= 0, "Songs are not sorted correctly by title");
		}
	}

	    @Test
	    void testSortedSongsBySongLength_FirstTitle() {
	        ArrayList<Song> sortedSongs = sc.sortSongsBySongLength();
	        assertEquals(sortedSongs.get(0).getTitle(), "good 4 u");
	    }

	    @Test
	    void testSortedSongsBySongLength_LastTitle() {
	        ArrayList<Song> sortedSongs = sc.sortSongsBySongLength();
	        assertEquals(sortedSongs.get(sortedSongs.size() - 1).getTitle(), "MONTERO");
	    }

	@Test
	public void testFindSongsById() {
		// fail("Not yet implemented");
		  SongCollection collection = new SongCollection();
	        Song song1 = new Song("0001", "good 4 u", "Olivia Rodrigo", 3.59);
	        Song song2 = new Song("0002", "Peaches", "Justin Bieber", 3.18);

	        // Add songs to the collection (you'll need to implement this)
	        collection.addSong(song1);
	        collection.addSong(song2);

	        assertEquals(song1, collection.findSongsById("0001"));
	        assertEquals(song2, collection.findSongsById("0002"));
	        assertNull(collection.findSongsById("0003"));
	}

	@Test
	public void testFindSongByTitle() {
		// fail("Not yet implemented");
		SongCollection collection = new SongCollection();
        Song song1 = new Song("0001", "good 4 u", "Olivia Rodrigo", 3.59);
        Song song2 = new Song("0002", "Peaches", "Justin Bieber", 3.18);

        // Add songs to the collection (you'll need to implement this)
        collection.addSong(song1);
        collection.addSong(song2);

        assertEquals(song1, collection.findSongByTitle("good 4 u"));
        assertEquals(song2, collection.findSongByTitle("Peaches"));
        assertNull(collection.findSongByTitle("MONTERO"));
	}

	@Test
	  void testGettersAndSetters() {
        Song song = new Song("006", "Somewhere I Belong", "Linkin Park", 3.46);
        
        assertEquals("006", song.getId());
        assertEquals("Somewhere I Belong", song.getTitle());
        assertEquals("Linkin Park", song.getArtiste());
        assertEquals(3.46, song.getSongLength());
        
        song.setId("007");
        song.setTitle("Shivers");
        song.setArtiste("Ed Sheeran");
        song.setSongLength(3.58);
        
        assertEquals("007", song.getId());
        assertEquals("Shivers", song.getTitle());
        assertEquals("Ed Sheeran", song.getArtiste());
        assertEquals(3.58, song.getSongLength());
    }
	@Test
	void testHashCodeAndEquals() {
	    Song song1 = new Song("006", "Somewhere I Belong", "Linkin Park", 3.46);
	    Song song2 = new Song("006", "Somewhere I Belong", "Linkin Park", 3.46);
	    Song song3 = new Song("007", "Easy On Me", "Adele", 5.32);
	    assertEquals(song1.hashCode(), song2.hashCode());
	    assertNotEquals(song1.hashCode(), song3.hashCode());
	    assertEquals(song1, song2);
	    assertNotEquals(song1, song3);
	}
	 @Test
	    void testTitleComparator() {
	        List<Song> songs = new ArrayList<>();
	        songs.add(s1);
	        songs.add(s2);
	        songs.add(s3);
	        songs.add(s4);

	        Collections.sort(songs, Song.titleComparator);

	        assertEquals("MONTERO", songs.get(0).getTitle());
	        assertEquals("Peaches", songs.get(1).getTitle());
	        assertEquals("bad guy", songs.get(2).getTitle());
	        assertEquals("good 4 u", songs.get(3).getTitle());
	    }

}


