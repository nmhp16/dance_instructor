# AI Dance Instructor

## **Usage Instructions**
- Use (`motion_database`) to collect pro dancer data by adding a video file and run (`PoseDetection.py`).
- (`pose_detection`) collects user data by video capture when running a Java application.
- Run (`Starter.java`) to start the Java application.
- Run the JavaFX UI with (`DanceInstructorUI.java`) by `mvn javafx:run`

## Current Packages

1. ### com.instructor.algorithms
   - **MergeSort**: Implements the Merge Sort algorithm to sort user performance or rankings efficiently.
   - **DecisionTree**: 
     - Utilizes Weka for training a decision tree model to classify dance poses based on keypoint data.
   - **DynamicTimeWarping**: 
     - Accounts for differences in frame rates and timing between user and professional poses, facilitating accurate comparisons.

2. ### com.instructor.data
   - **PoseDataReader**: Responsible for reading and importing pose keypoint data from video files into the system.
   - **PoseDataProcessing**: Processes imported keypoint data to normalize and prepare it for evaluation.

3. ### com.instructor.evaluation
   - **PoseFeedback**: Provides real-time feedback to users based on their pose accuracy compared to the professional dancer's poses.
   - **PoseScoring**: Implements algorithms to calculate a similarity score between user poses and reference poses, aiding in performance assessment.

4. ### com.instructor.main
   - **Starter**: The application's main entry point, initializing components and starting the pose estimation and evaluation process.
   - **DanceInstructorUI**: Launches JavaFX user interface.
   - **DanceInstructorUIController**: Handle button and UI interaction in `DanceInstructorUI.fxml` created by `SceneBuilder`.

## MediaPipe Keypoints (33)
![MediaPipes-33-key-points-29-1](https://github.com/user-attachments/assets/a61fac5e-3127-4d5b-ad49-0227656b3ee6)

- **Keypoints Used (25)**:
  - nose
  - left_eye, right_eye
  - left_ear, right_ear
  - shoulder_left, shoulder_right
  - elbow_left, elbow_right
  - wrist_left, wrist_right
  - left_thumb_tip, right_thumb_tip
  - left_index_finger_tip, right_index_finger_tip
  - hip_left, hip_right
  - knee_left, knee_right
  - ankle_left, ankle_right
  - heel_left, heel_right
  - foot_index_left, foot_index_right
