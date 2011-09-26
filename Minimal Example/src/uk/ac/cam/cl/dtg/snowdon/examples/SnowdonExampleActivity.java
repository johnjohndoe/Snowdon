package uk.ac.cam.cl.dtg.snowdon.examples;

import uk.ac.cam.cl.dtg.snowdon.GraphView;
import android.app.Activity;
import android.os.Bundle;

public class SnowdonExampleActivity extends Activity {
	private GraphView mGraph;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mGraph = (GraphView) findViewById(R.id.example_graph);
        
        // Our datasets
        float[][] data1 = {{0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, {10.0f, 8.0f, 12.0f, 12.0f, 6.0f, 5.0f}};
        float[][] data2 = {{0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 7.0f}, {8.0f, 4.0f, 11.0f, 10.0f, 5.0f, 2.0f}};
        float[][] data3 = {{0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 7.0f}, {3.0f, 1.0f, 3.0f, Float.NaN, 2.0f, 7.0f}};
        
        // The first dataset must be inputted into the graph using setData to replace the placeholder data already there
        mGraph.setData(new float[][][]{data1}, 0, 5, 0, 15);
        
        // We want to add the second data set, but only adjust the max x value as all the other stay the same, so we input NaNs in their place
        mGraph.addData(data2, Float.NaN, 7, Float.NaN, Float.NaN);
        
        // Add the third dataset, which includes NaNs to signify a gap in the data
        mGraph.addData(data3, Float.NaN, Float.NaN, Float.NaN, Float.NaN);
        
        mGraph.setOverlay1Text("Snowdon", 0.1f, 0.1f);
    }
}