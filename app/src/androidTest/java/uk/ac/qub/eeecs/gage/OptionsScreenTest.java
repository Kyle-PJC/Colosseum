package uk.ac.qub.eeecs.gage;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.ac.qub.eeecs.gage.engine.AssetManager;
import uk.ac.qub.eeecs.gage.engine.io.FileIO;
import uk.ac.qub.eeecs.game.DemoGame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Options Screen AssetStore Unit Tests. Story  - Scott Barham
 * <p>
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class OptionsScreenTest {

    private Context context;
    private DemoGame game;

    @Before
    public void setUp() {

        context = InstrumentationRegistry.getTargetContext();
        game = new DemoGame();
        game.mFileIO = new FileIO(context);
    }

    //Using example tests given with my Back button bitmaps - Story
    @Test
    public void loadAndAddBackButton_ValidData() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for successful load
        String assetName = "BackArrow", assetPath = "img/BackArrow.png";
        assertTrue(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void loadAndAddBackButtonSelected_ValidData() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for successful load
        String assetName = "BackArrowSelected", assetPath = "img/BackArrowSelected.png";
        assertTrue(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test(expected = RuntimeException.class)
    public void loadAndAddInvalidBackButton_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for an unsuccessful load
        String assetName = "BackArrow3", assetPath = "img/NoBackArrow.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
    }

    @Test
    public void loadAndAddBackButton_AlreadyLoadedAsset_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it cannot be added a second time
        String assetName = "BackArrow", assetPath = "img/BackArrow.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertFalse(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void getBackButton_ValidGet_TestIsSuccess() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it can be extracted
        String assetName = "BackArrow", assetPath = "img/BackArrow.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertNotNull(assetManager.getBitmap(assetName));
    }

    @Test
    public void loadAndAddBackButtonSelected_AlreadyLoadedAsset_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it cannot be added a second time
        String assetName = "BackArrowSelected", assetPath = "img/BackArrowSelected.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertFalse(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void getBackButtonSelected_ValidGet_TestIsSuccess() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it can be extracted
        String assetName = "BackArrowSelected", assetPath = "img/BackArrowSelected.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertNotNull(assetManager.getBitmap(assetName));
    }

    //Story O3 Tests on background image

    @Test
    public void loadAndAddBackground_ValidData() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for successful load
        String assetName = "OptionsBackground", assetPath = "img/OptionsBackground.png";
        assertTrue(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test(expected = RuntimeException.class)
    public void loadAndAddBackground_Invalid_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for an unsuccessful load
        String assetName = "BackgroundOptions", assetPath = "img/BackgroundOptions.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
    }

    @Test
    public void loadAndAddBackground_AlreadyLoadedAsset_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it cannot be added a second time
        String assetName = "OptionsBackground", assetPath = "img/OptionsBackground.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertFalse(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void getBackground_ValidGet_TestIsSuccess() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it can be extracted
        String assetName = "OptionsBackground", assetPath = "img/OptionsBackground.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertNotNull(assetManager.getBitmap(assetName));
    }

    //Sprint 4, Story 18 toggle button asset tests

    @Test
    public void loadAndAddEdgeCaseButton_ValidData() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for successful load
        String assetName = "CoinFlip", assetPath = "img/coinflip.png";
        assertTrue(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test(expected = RuntimeException.class)
    public void loadAndAddEdgeCaseButton_Invalid_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for an unsuccessful load
        String assetName = "flipacoin", assetPath = "img/flipacoin.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
    }

    @Test
    public void loadAndAddEdgeCaseButton_AlreadyLoadedAsset_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it cannot be added a second time
        String assetName = "CoinFlip", assetPath = "img/coinflip.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertFalse(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void getEdgeCaseButton_ValidGet_TestIsSuccess() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it can be extracted
        String assetName = "CoinFlip", assetPath = "img/coinflip.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertNotNull(assetManager.getBitmap(assetName));
    }

    @Test
    public void loadAndAddEdgeCaseSelectedButton_ValidData() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Check for successful load
        String assetName = "CoinFlipSelected", assetPath = "img/coinflipselected.png";
        assertTrue(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void loadAndAddEdgeCaseSelectedButton_AlreadyLoadedAsset_TestErrorReport() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it cannot be added a second time
        String assetName = "CoinFlipSelected", assetPath = "img/coinflipselected.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertFalse(assetManager.loadAndAddBitmap(assetName, assetPath));
    }

    @Test
    public void getEdgeCaseSelectedButton_ValidGet_TestIsSuccess() {
        // Build asset store
        AssetManager assetManager = new AssetManager(game);
        // Load a bitmap and test it can be extracted
        String assetName = "CoinFlipSelected", assetPath = "img/coinflipselected.png";
        assetManager.loadAndAddBitmap(assetName, assetPath);
        assertNotNull(assetManager.getBitmap(assetName));
    }
}
