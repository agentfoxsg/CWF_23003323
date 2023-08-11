package com.sddevops.CWF_23003323;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CWFSongTestCollection {
	private SongCollection sc;
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private final int SONG_COLLECTION_SIZE=4; 

	@BeforeEach
	void setUp() throws Exception {
		sc=new SongCollection();
		s1 = new Song("001","good 4 u","Olivia Rodrigo",3.59);
		s2 = new Song("002","Peaches","Justin Bieber",3.18);
		s3 = new Song("003","MONTERO","Lil Nas",2.3);
		s4 = new Song("004","bad guy","billie eilish",3.14);
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
		//fail("Not yet implemented");
		   List<Song> songs = sc.getSongs();
	        assertEquals(SONG_COLLECTION_SIZE, songs.size());
	        assertTrue(songs.contains(s1));
	        assertTrue(songs.contains(s2));
	        assertTrue(songs.contains(s3));
	        assertTrue(songs.contains(s4));
	}
	
	@Test
	void testAddSong() {
		//fail("Not yet implemented");
		List<Song> testSc=sc.getSongs();
		//Assert that Song Collection is equals to Song Collection Size : 4
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE);
		//Act
		sc.addSong(s1);
		//Assert that Song Collection is equals to Song Collection Size + 1 : 5
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE+1);
	}

	@Test
	void testSortSongsByTitle() {
		//fail("Not yet implemented");
		 ArrayList<Song> sortedSongs = sc.sortSongsByTitle();
	        for (int i = 1; i < sortedSongs.size(); i++) {
	            String previousTitle = sortedSongs.get(i - 1).getTitle();
	            String currentTitle = sortedSongs.get(i).getTitle();
	            assertTrue(previousTitle.compareTo(currentTitle) <= 0, "Songs are not sorted correctly by title");
	        }
	}

	@Test
	void testSortSongsBySongLength() {
		//fail("Not yet implemented");
		  ArrayList<Song> sortedSongs = sc.sortSongsBySongLength();
	        for (int i = 1; i < sortedSongs.size(); i++) {
	            double previousLength = sortedSongs.get(i - 1).getSongLength();
	            double currentLength = sortedSongs.get(i).getSongLength();
	            assertTrue(previousLength <= currentLength, "Songs are not sorted correctly by song length");}
	        }

	@Test
	void testFindSongsById() {
		//fail("Not yet implemented");
	      Song foundSong = sc.findSongsById("003");
	        assertNotNull(foundSong);
	        assertEquals("MONTERO", foundSong.getTitle());
	    }

	@Test
	void testFindSongByTitle() {
		//fail("Not yet implemented");
	      Song foundSong = sc.findSongByTitle("Peaches");
	        assertNotNull(foundSong);
	        assertEquals("Justin Bieber", foundSong.getArtiste());
	    }
	}
