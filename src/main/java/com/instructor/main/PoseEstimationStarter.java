package com.instructor.main;

import com.instructor.data.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PoseEstimationStarter {

    // Method to run the Python script
    private void runPythonScript() {
        try {
            // Define the command to run the Python script
            String pythonScriptPath = "./pose_detection/PoseDetection.py"; // Relative path
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);

            // Set the redirect error stream to true to capture errors
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Instantiate PoseDataReader
        PoseDataReader poseDataReader = new PoseDataReader();

        // Instantiate Hashmap to store user key points
        // Map <Keypoints (ex: left_leg), Map<Frame (ex: 1), coordinates (x,y,z)>>
        Map<String, Map<Integer, float[]>> userKeypointsMap = new HashMap<>();

        // Create the entry point for communication
        PoseEstimationStarter handler = new PoseEstimationStarter();

        // Start video to capture user dance, and generate a .txt file
        System.out.println("Starting video capture from Python...");
        handler.runPythonScript();

        // Read this .txt file to populate userKeypoints
        userKeypointsMap = poseDataReader.readKeypointsFromFile("keypoints_data.txt");

        // TODO: Remove later, keep for test purposes
        poseDataReader.displayPoseData(userKeypointsMap); // Display pose coordinates

    }
}
